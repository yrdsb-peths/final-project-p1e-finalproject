import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first world to be loaded
 * 
 * @author Jayden, Carl
 * @version 2022.01.26
 */
public class TitleScreen extends World
{
    // Default variables
    boolean lever = false;
    boolean leverB = false;

    Button playButton = new Button();
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(1280, 720, 1); 
        GreenfootImage title = new GreenfootImage("titlescreen.png");
        title.scale(1280,720);
        setBackground(title);
        addObject(playButton, getWidth()/2, getHeight()/2 + 100);
    }

    // Act method
    public void act() {
        // Press space to continue (Mainly for debugging purposes. user won't be prompted to press space)
        if ((("space").equals(Greenfoot.getKey()) && !lever)) {
            changeWorld();
            lever = true;
        }
    }

    // Change world to instructions screen
    private void changeWorld() {
        Greenfoot.setWorld(new InstructionsScreen());
    }
}
