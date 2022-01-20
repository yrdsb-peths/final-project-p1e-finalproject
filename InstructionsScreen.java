import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen informing two users how to play the game
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsScreen extends World
{
    boolean lever = false;

    /**
     * Constructor for objects of class InstructionsScreen.
     * 
     */
    public InstructionsScreen()
    {    
        super(1280, 720, 1);
        // setImage(Instructions image); 
    }

    public void act() {
        // Press any key to continue
        if (("space").equals(Greenfoot.getKey()) && !lever) {
            changeWorld();
            lever = true;
        }
    }

    public void changeWorld() {
        Greenfoot.setWorld(new MyWorld());
    }
}
