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
    ArrayList<String> inputs;
    ArrayList<String> dates;
    String[][] scores;
    int winner = 1; // 0 is tie | 1 is player 1 win | 2 is player 2 win
    int score = 1; // min * 100 + sec * 10

    boolean lever = false;

    /**
     * Constructor for objects of class ScoresWorld.
     * 
     */
    public ScoresWorld(int winner, int min, int sec)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        this.winner = winner;
        this.score = min*100 + sec*10;
        if (!lever) run();
    }
    
    private void run() {
        lever = true;
        ScoreUtilities.writeScore("2000");
        ScoreUtilities
    }
}
