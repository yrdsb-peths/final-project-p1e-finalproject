import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor implements Playable
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static GreenfootImage image2 = new GreenfootImage("snake2.png");
    public static int orientationSnake = 0;
    
    public void act()
    {
        // Add your action code here.
    }
    
    public GreenfootImage getImage() {
        return image2;
    }

    public int auto() {
        return 1;
    }

    public int special() {
        System.out.println("Snake uses special!");
        return 1;
    }
}
