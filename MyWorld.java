import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // Middle dimensions
    int x = getWidth()/2;
    int y = getHeight()/2;
 
    // Players
    Pig player1;
    MrOrange player2; 

    // Player stocks
    int oneStock = 3;
    int twoStock = 3;

    public void act() {
        try {
            if (player1.isAtEdge()) {
                if (oneStock > 0) {
                    respawn(player1);
                    oneStock--;
                }
                else gameOver(player1);
            }
            if (player2.isAtEdge()) {
                if (twoStock > 0) {
                    respawn(player2);
                    twoStock--;
                }
                else gameOver(player2);
            }
        }
        catch (Exception e){} // Change world
    }

    public void gameOver(Character actor) {
        if (oneStock == 0) { 
            removeObject(actor);
            System.out.println("Player 2 wins");
        }
        else { 
            removeObject(actor);
            System.out.println("Player 1 wins");
        }
    }

    public void respawn(Character actor) {
        actor.setLocation(x,y);
    }

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        // "up", "left", "down", "right", "n", "m"
        // "w", "a", "s", "d", "g", "h"
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        player1 = new Pig("w", "a", "s", "d", "g", "h");
        player2 = new MrOrange("up", "left", "down", "right", "n", "m");
        addObject(player1, 462, 435);
        addObject(player2, 900, 425);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PlatformX platformX = new PlatformX();
        addObject(platformX,656,487);
        PlatformYL platformYL = new PlatformYL();
        addObject(platformYL,346,589);
        PlatformYR platformYR = new PlatformYR();
        addObject(platformYR,966,590);
        Platform platform = new Platform();
        addObject(platform,857,312);
    }
}
