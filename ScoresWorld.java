import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class ScoresWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoresWorld extends World
{
    ArrayList<String> inputs = new ArrayList<String>();
    ArrayList<String> dates;
    ArrayList<Integer> scores;
    // And how to update scores during the game...
    /**
     * Constructor for objects of class ScoresWorld.
     * 
     */
    public ScoresWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        inputs = ReadFile.extractScores();
    }
    
    public String returnDate(String input) {
        int delimiter = input.indexOf('-');
        return input.substring(0, delimiter);
    }
    
    public int returnScore(String input) {
        int delimiter = input.indexOf('-');
        return Integer.parseInt((input.substring(delimiter + 1, input.length())));
    }
}
