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

    public void controls() {
        // Jump
        if ("w".equals(Greenfoot.getKey())) {
            if (counter < 2) {
                jump();
                counter++;
            }
        }
        // Move left
        if (Greenfoot.isKeyDown("a")) {
            if (isTouchingR() && isInAir()) move(2);
            else if (isInAir()) move(-2);
            else move(-5);
        }
        // Duck down
        if (Greenfoot.isKeyDown("s")) {
            System.out.println(getY());
        }
        // Move right
        if (Greenfoot.isKeyDown("d")) {
            if (isTouchingL() && isInAir()) move(-2);
            else if (isInAir()) move(2);
            else move(5);
        }
        // Dev: Reset jump counter
        if (Greenfoot.isKeyDown("q")) print(isTouchingL());
    }

    public void print(Object x) {System.out.println(x);}

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
