import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pig extends Player
{
    
    
    /**
     * Act - do whatever the player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] p2jump = new GreenfootImage[12];
    GreenfootImage p2idle = new GreenfootImage("p2idle1.png");
    
    public pig()
    {
        p2idle.scale(105,115);
        setImage(p2idle);
    }
    
    public void act()
    {
        player2movement(p2jump, p2idle);
    }
}
