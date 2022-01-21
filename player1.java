import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player1 extends Player
{
    
    
    /**
     * Act - do whatever the player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] p1jump = new GreenfootImage[12];
    GreenfootImage p1idle = new GreenfootImage("p1idle1.png");
    
    public player1()
    {
        p1idle.scale(30,90);
        setImage(p1idle);
    }
    
    public void act()
    {
        player1movement(p1jump, p1idle, p1idle, p1idle);
    }
}
