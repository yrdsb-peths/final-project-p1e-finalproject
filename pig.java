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
    GreenfootImage p2idle2 = new GreenfootImage("p2idle2.png");
    GreenfootImage p2run1 = new GreenfootImage("p2run1.png");
    GreenfootImage p2run2 = new GreenfootImage("p2run2.png");
    GreenfootImage p2run3 = new GreenfootImage("p2run1.png");
    GreenfootImage p2run4 = new GreenfootImage("p2run2.png");
    
    public pig()
    {
        p2idle2.scale(105,115);
        p2idle.scale(105,115);
        p2run1.scale(105,115);
        p2run2.scale(105,115);
        p2run3.scale(105,115);
        p2run4.scale(105,115);
        p2run3.mirrorHorizontally();
        p2run4.mirrorHorizontally();
        setImage(p2idle);
    }
    
    public void act()
    {
        idle(p2idle, p2idle2);
        player2movement(p2jump, p2idle, p2run1, p2run2, p2run3, p2run4);
    }
}
