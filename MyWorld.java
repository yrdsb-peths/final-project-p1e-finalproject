import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int x = getWidth()/2;
    int y = getHeight()/2;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        GreenfootImage background = new GreenfootImage("Background.jpg");
        setBackground(background);
        addObject(new Hedgehog(), x, y);
        addObject(new Apple(), x, y);
        addObject(new Platform(), 618, 511);
        setPaintOrder(Character.class);
    }
}
