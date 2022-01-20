import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
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
    public TitleScreen()
    {    
        super(1280, 720, 1); 
        Label title = new Label("The game", 150);
        addObject(title, getWidth()/2, getHeight()/2);
    }

    public void act() {
        // Press space to continue
        if (("space").equals(Greenfoot.getKey()) && !lever) {
            changeWorld();
            lever = true;
        }
    }

    public void changeWorld() {
        Greenfoot.setWorld(new InstructionsScreen());
    }
}
