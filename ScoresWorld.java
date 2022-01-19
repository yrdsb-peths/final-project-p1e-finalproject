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
    int score; // min * 100 + sec * 10

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
        ScoreUtilities.writeScore(Integer.toString(score));
        ArrayList<String> inputs = ScoreUtilities.extractScores();
        scores = ScoreUtilities.convertArray(inputs);
        ScoreUtilities.quickSort(scores);
        ScoreUtilities.reverse(scores);
        displaySessionScore();
        displayScores();
    }

    private void displayScores() {
        Label title = new Label("Top 5 High Scores", 100);
        addObject(title, getWidth()/2, (getHeight()/2)-100);
        Label underline = new Label("________________", 100);
        addObject(underline, getWidth()/2, (getHeight()/2)-90);
        for (int i = 0; i < 5; i++) {
            Label label = new Label(scores[i][0] + " scored on " + scores[i][1], 75);
            addObject(label, getWidth()/2, (getHeight()/2) + (i*70));
        }
    }

    private void displaySessionScore() {
        Label l = new Label("Winner's Score: " + Integer.toString(score), 150);
        addObject(l, getWidth()/2, (getHeight()/2)-250);
    }
}
