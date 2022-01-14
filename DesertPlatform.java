import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DesertPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DesertPlatform extends Actor
{
    /**
     * Act - do whatever the DesertPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DesertPlatform()
    {
        GreenfootImage desert = new GreenfootImage("platform 1.png");
        desert.scale(1280,720);
        setImage(desert);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
