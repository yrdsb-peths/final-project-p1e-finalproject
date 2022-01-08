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
    private int jumpHeight = -5;

    public void controls() {
        if (Greenfoot.isKeyDown("w")) { // Only to jump once
            velocity = jumpHeight; 
            fall(); 
        }
        if (Greenfoot.isKeyDown("a")) {
            if (!inAir()) setLocation(getX()-5, getY());
            else setLocation(getX()-3, getY());
        }
        if (Greenfoot.isKeyDown("s")) {
            if (touchingGround()) {
                while (touchingGround()) {
                    fall();
                }
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            if (!inAir()) setLocation(getX()+5, getY());
            else setLocation(getX()+3, getY());
        }
    }

    public void gravity() {
        if (!onGround() || !touchingGround()) {
            fall();
        }
    }

    public void fall() {
        setLocation(getX(), getY() + (int) velocity);
        velocity = velocity + acceleration;
    }
    
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Platforms.class);
        return under != null;
    }
    
    public boolean touchingGround() {
        if (isTouching(Platforms.class)) return true;
        return false;
    }
    
    public boolean inAir() {
        if (touchingGround()) return false;
        return true;
    }
}
