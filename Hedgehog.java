import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hedgehog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hedgehog extends Character
{
    /**
     * Act - do whatever the Hedgehog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        controls("g", "h");
        turnAtOpponent();
        gravity();
    }
    
    public int auto() {
        return 1;
    }
    
    public int special() {
        return 1;
    }
}
