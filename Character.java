import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent class that contains methods that all Characters require
 * 
 * @author Carl and Yoyo
 * @version 2022.01.20
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
    
    /**
     * Method controls the movement of characters and sets the direction they are facing
     * 
     * @param up String/key for jumping
     * @param left String/key for moving left and setting image to go left
     * @param down String/key to duck under thin platforms
     * @param right String/key to move right and setting image to go right
     * @param auto String/key to use Playable's auto move
     * @param special String/key to use Playble's special move
     * @param actor String/key The actor that is to be controlled
     */
    public void controls(String up, String left, String down, String right, String auto, String special, Playable actor) {
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
    
    /**
     * Method allows characters to fall if not on platform
     */
    public void gravity() {
        if (!isOnGround() && !isTouchingPlatform()) fall();
        else {
            velocity = 0;
            counter = 0;
        }
    }
    
    /**
     * Method allows characters to fall
     */
    private void fall() {
        setLocation(getX(), getY() + (int) velocity);
        velocity = velocity + acceleration;
    }

    /**
     * Method allows character to jump while following gravity
     */
    private void jump() {
        velocity = jumpHeight; 
        fall(); 
    }

    // Getters and Setters
    public SimpleTimer getAutoTimer(){
        return autoTimer;
    }
    
    public void setCanUseSpecial(boolean newCanUseSpecial){
        canUseSpecial = newCanUseSpecial;
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

    // Returns true if touching main (thick) platform
    private boolean isOnGround() {
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, PlatformX.class);
        if (platform != null){
            if(getImage() == Pig.bigImageRight || getImage() == Pig.bigImageLeft){
                setLocation(getX(), 420);
            } else {
                setLocation(getX(), 438);
            }
        }
        return platform != null;
    }

    // Returns true if touching secondary (thin) platform
    private boolean isTouchingPlatform() {
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, PlatformSmall.class);
        if (platform != null){
            if(getImage() == Pig.bigImageRight || getImage() == Pig.bigImageLeft){
                setLocation(getX(), 270);
            } else {
                setLocation(getX(), 288);
            }
        }
        return platform != null;
    }
}
