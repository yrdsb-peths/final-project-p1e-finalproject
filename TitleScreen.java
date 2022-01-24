import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first world to be loaded
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    boolean lever = false;

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    Button playButton = new Button();
    
    public TitleScreen()
    {    
        super(1280, 720, 1); 
        GreenfootImage title = new GreenfootImage("titlescreen.png");
        title.scale(1280,720);
        setBackground(title);
        
        
        addObject(playButton, getWidth()/2, getHeight()/2 + 100);
    }

    public void act() {
        // Press space to continue
        
        if ((("space").equals(Greenfoot.getKey()) && !lever) || (Greenfoot.mouseClicked(playButton) && !lever)) {
            changeWorld();
            lever = true;
        }
    }

    public void changeWorld() {
        Greenfoot.setWorld(new InstructionsScreen());
    }
}
