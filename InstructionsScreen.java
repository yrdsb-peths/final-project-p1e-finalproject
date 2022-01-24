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
    GreenfootImage image = new GreenfootImage("tempInstructions.png");
    
    /**
     * Constructor for objects of class InstructionsScreen.
     * 
     */
    public InstructionsScreen()
    {    
        super(1280, 720, 1);
        getBackground().drawImage(image, 0, 0);
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
