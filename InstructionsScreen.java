import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen informing two users how to play the game
 * 
 * @author Carl, Jayden
 * @version 2022.01.26
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
        GreenfootImage instructions = new GreenfootImage("instructions.png");
        instructions.scale(1280,720);
        setBackground(instructions);
    }

    public void act() {
        // Press any key to continue
        if (("space").equals(Greenfoot.getKey()) && !lever) {
            changeWorld();
            lever = true;
        }
    }

    public void changeWorld() {
        Greenfoot.setWorld(new CountdownScreen());
    }
}
