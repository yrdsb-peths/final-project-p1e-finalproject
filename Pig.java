import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pig extends Actor implements Playable
{
    GreenfootImage image = new GreenfootImage("pig.png");
    GreenfootImage imageDirectionB = new GreenfootImage("pig_left.png");
    
    /**
     * Act - do whatever the Pig wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    }
    
    public GreenfootImage getImage() {
        return image;
    }

    public int auto() {
        System.out.println("Pig attacks!");
        Greenfoot.delay(100);
        return 1;
    }

    public int special() {
        System.out.println("Pig uses special!");
        return 1;
    }

    /**
     * facingDirection - Facing right
     * 
     * DirectionB - Actor facing left
     */
    public void setDirection(String direction) {
        if (direction.equals("right")) setImage(image);
        else setImage(imageDirectionB);
    }
}
