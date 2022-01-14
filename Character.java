import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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

    // Movement variables
    private String up;
    private String left;
    private String down;
    private String right;
    private String auto;
    private String special;

    // Interface
    private Playable object;
    
    // Cooldown tracker
    private SimpleTimer autoTimer = new SimpleTimer();
    private SimpleTimer specialTimer = new SimpleTimer();

    // Loop control
    private boolean kDown;

    public Character(Playable object, String up, String left, String down, String right, String auto, String special) {
        this.object = object;
        setImage(this.object.getImage());

        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.auto = auto;
        this.special = special;
    }
    
    public void act() {
        controls();
        gravity();
        if (isAtEdge()) System.out.println("Game end"); // Do something
    }

    private void controls() {
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
            if (isTouchingL() && isInAir()) setLocation(getX()-2, getY());
            else if (isInAir()) setLocation(getX()+2, getY());
            else setLocation(getX()+5, getY());
        }
        // Auto
        if (autoTimer.millisElapsed() > 500 && Greenfoot.isKeyDown(auto)) {
            object.auto();
            autoTimer.mark();
        }
        // Special
        if (specialTimer.millisElapsed() > 2000 && Greenfoot.isKeyDown(special)) {
            object.special();
            specialTimer.mark();
        }
    }

    private void gravity() {
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
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        if (platform != null) setLocation(getX(), 288); // Locks character in place. Determine y.
        return platform != null;
    }

    private void death() {
        // What to do when character touches the edge of the world
    }
}
