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
    private double velocity = 0;
    private double acceleration = .2;
    private int jumpHeight = -5;
    
    public void turnAtOpponent() {
        if (!getWorld().getObjects(Apple.class).isEmpty()) // If Actor is in World
        {
            Actor actor = (Actor) getWorld().getObjects(Apple.class).get(0); // Get Actor reference
            int x = actor.getX(); 
            int y = actor.getY(); 
            turnTowards(x, y);
        }
    }
    
    public void controls(String auto, String special) {
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
        if (Greenfoot.isKeyDown(auto)) {
            
        }
    }
    
    public void fall() {
        setLocation(getX(), getY() + (int) velocity);
        velocity = velocity + acceleration;
    }
    
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        return under != null;
    }
    
    public void gravity() {
        if (!onGround() || !touchingGround()) {
            fall();
        }
    }
    
    public boolean touchingGround() {
        if (isTouching(Platform.class)) return true;
        return false;
    }
    
    public boolean inAir() {
        if (touchingGround()) return false;
        return true;
    }
    
    // Collision
}
