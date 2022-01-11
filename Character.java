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

    private String up = "w";
    private String left = "a";
    private String down = "s";
    private String right = "d";

    // Interface
    private Abilities object;

    public Character(Abilities object) {
        this.object = object;
    }
    
    public void act() {
        controls();
        gravity();
    }

    public void controls() {
        // Jump
        if (up.equals(Greenfoot.getKey())) {
            if (counter < 2) {
                jump();
                counter++;
            }
        }
        // Move left
        if (Greenfoot.isKeyDown(left)) {
            if (isTouchingR() && isInAir()) move(2);
            else if (isInAir()) move(-2);
            else move(-5);
        }
        // Duck down
        if (Greenfoot.isKeyDown(down)) {
            System.out.println(getY());
        }
        // Move right
        if (Greenfoot.isKeyDown(right)) {
            if (isTouchingL() && isInAir()) move(-2);
            else if (isInAir()) move(2);
            else move(5);
        }
        // Auto
        // Special
    }

    public void gravity() {
        if (!isOnGround()) fall();
        else {
            velocity = 0;
            counter = 0;
        }
    }

    public void jump() {
        velocity = jumpHeight; 
        fall(); 
    }

    public void fall() {
        setLocation(getX(), getY() + (int) velocity);
        velocity = velocity + acceleration;
    }
    
    public boolean isOnGround() {
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, PlatformX.class);
        if (platform != null) setLocation(getX(), 438);
        return platform != null;
    }

    public boolean isInAir() {
        if (isOnGround()) return false;
        return true;
    }

    public boolean isTouchingL() {
        if (isTouching(PlatformYL.class)) return true;
        return false;
    }

    public boolean isTouchingR() {
        if (isTouching(PlatformYR.class)) return true;
        return false;
    }
}
