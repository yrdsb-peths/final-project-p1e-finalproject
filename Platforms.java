import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platforms here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platforms extends World
{

    /**
     * Constructor for objects of class Platforms.
     * 
     */
    
    public Platforms()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 700, 1); 

        GreenfootImage sky = new GreenfootImage("sky1.png");
        sky.scale(getWidth(), getHeight());

        setBackground(sky);
        prepare();
    }

    public void Hover()
    {

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        DesertPlatform desertPlatform = new DesertPlatform();
        addObject(desertPlatform,getWidth()/2,500);

        player1 player1 = new player1();
        addObject(player1,464,415);

        pig pig = new pig();
        addObject(pig,882,415);
    }
}
