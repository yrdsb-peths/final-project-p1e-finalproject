import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first world to be loaded
 * 
 * @author Jayden, Carl
 * @version 2022.01.26
 */
public class TitleScreen extends World
{
    boolean lever = false;
    boolean leverB = false;

    Button playButton = new Button();
    public static Pig pig;
    public static Snake snake; 
    
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
        // Press space to continue
        if ((("space").equals(Greenfoot.getKey()) && !lever) || (Greenfoot.mouseClicked(playButton) && !lever)) {
            changeWorld();
            lever = true;
        }
        runOnce();
    }
    
    public void runOnce() {
        if (!leverB) {
            SoundEffects.playTheme();
            leverB = true;
        }
    }

    public void changeWorld() {
        Greenfoot.setWorld(new InstructionsScreen());
    }
}
