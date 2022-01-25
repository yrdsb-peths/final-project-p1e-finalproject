import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinnerWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinnerWorld extends World
{

    /**
     * Constructor for objects of class WinnerWorld.
     * 
     */
    GreenfootImage pigWinner = new GreenfootImage("snake winner.png");
    GreenfootImage snakeWinner = new GreenfootImage("pig winner.png");
    
    boolean pig = true;
    
    public WinnerWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        
        snakeWinner.scale(1280,720);
        pigWinner.scale(1280,720);
        
        setBackground(pigWinner);
    }
    
    public void run()
    {
        if(/*pig wins*/ pig = true) {
            setBackground(snakeWinner);
            //scaled pig does idle animation on right side
            //small snake does idle animation in box
        }
        else {
            setBackground(snakeWinner);
            //scaled snake does idle animation on right side
            //small pig does idle animation in box
        }
        
    }
}
