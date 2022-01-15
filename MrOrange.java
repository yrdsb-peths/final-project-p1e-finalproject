import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MrOrange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MrOrange extends Actor implements Playable
{
    GreenfootImage image = new GreenfootImage("ppl3.png");
    GreenfootImage imageDirectionB = new GreenfootImage("ppl3_left.png");

    /**
     * Act - do whatever the MrOrange wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    public GreenfootImage getImage() {
        return image;
    }

    public int auto() {
        System.out.println("Mr Orange autos!");
        return 1;
    }

    public int special() {
        System.out.println("Mr Orange uses special!");
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
