import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    // Jumping and gravity
    private double velocity = 0;
    private double acceleration = .2;
    private int jumpHeight = -7;

    // Jump counter
    private int counter = 0;
    
    // Cooldown tracker
    private SimpleTimer autoTimer = new SimpleTimer();
    private boolean canUseSpecial = false;

    // Loop control
    private boolean kDown;
    
    
    public void controls(String id, String up, String left, String down, String right, String auto, String special, Playable actor) {
        // Jump
        if (kDown != Greenfoot.isKeyDown(up)) {
            kDown = !kDown;
            if (kDown && counter < 2) {
                jump();
                counter++;
            }
        }
        // Move left
        if (Greenfoot.isKeyDown(left)) {
            actor.direction("left");
            if (isTouchingR() && isInAir()) setLocation(getX()+2, getY());
            else if (isInAir()) setLocation(getX()-2, getY());
            else setLocation(getX()-5, getY());
        }
        // Duck down
        if (Greenfoot.isKeyDown(down)) {
            if (isTouchingPlatform()) while (isTouchingPlatform()) fall();
        }
        // Move right
        if (Greenfoot.isKeyDown(right)) {
            actor.direction("right");
            if (isTouchingL() && isInAir()) setLocation(getX()-2, getY());
            else if (isInAir()) setLocation(getX()+2, getY());
            else setLocation(getX()+5, getY());
        }
        // Auto
        if (autoTimer.millisElapsed() > 500 && Greenfoot.isKeyDown(auto)) {
            actor.auto();
            autoTimer.mark();
        }
        // Special
        // Take out canUseSpecial to test special
        if (Greenfoot.isKeyDown(special)) {
            actor.special();
            canUseSpecial = false;
        }
    }
    
    // Getters and Setters
    public SimpleTimer getAutoTimer(){
        return autoTimer;
    }
    
    public void setCanUseSpecial(boolean newCanUseSpecial){
        canUseSpecial = newCanUseSpecial;
    }

    public void gravity() {
        if (!isOnGround() && !isTouchingPlatform()) fall();
        else {
            velocity = 0;
            counter = 0;
        }
    }

    private void jump() {
        velocity = jumpHeight; 
        fall(); 
    }

    private void fall() {
        setLocation(getX(), getY() + (int) velocity);
        velocity = velocity + acceleration;
    }
    
    private boolean isOnGround() {
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, PlatformX.class);
        if (platform != null) setLocation(getX(), 438); // Locks character in place. Determine y.
        return platform != null;
    }

    private boolean isInAir() {
        if (isOnGround() || isTouchingPlatform()) return false;
        return true;
    }

    private boolean isTouchingL() {
        if (isTouching(PlatformYL.class)) return true;
        return false;
    }

    private boolean isTouchingR() {
        if (isTouching(PlatformYR.class)) return true;
        return false;
    }

    private boolean isTouchingPlatform() {
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, PlatformSmall.class);
        if (platform != null) setLocation(getX(), 288); // Locks character in place. Determine y experimentally.
        return platform != null;
    }
}
