import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * World that displays the session score and the past 5 highest scores
 * Top 5 highest scores can include the session score
 * 
 * @author Carl
 * @version 2022.01.20
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
    public ScoresWorld(int winner, int timeElasped)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        this.winner = winner;
        this.score = 120000-timeElasped;
        if (!lever) run();
    }
    
    /**
     * Writes the session score to text file
     * Extracts data from textfile and processes the data
     */
    private void run() {
        lever = true;
        ScoreUtilities.writeScore(Integer.toString(score));
        ArrayList<String> inputs = ScoreUtilities.extractScores();
        scores = ScoreUtilities.convertArray(inputs); 
        ScoreUtilities.quickSort(scores);
        ScoreUtilities.reverse(scores);
        displaySessionScore();
        displayScores();
        SoundEffects.stopTheme();
        announceResult();
    }

    /**
     * Announces the outcome of the battle
     */
    private void announceResult() {
        if (winner == 1) SoundEffects.player1Sound();
        if (winner == 2) SoundEffects.player2Sound();
        if (winner == 0) SoundEffects.tieSound();
    }

    /**
     * Create the labels to display top 5 previous (or 4 previous + 1 current) high scores
     */
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

    /**
     * Create the label to display the session score
     */
    private void displaySessionScore() {
        Label l = new Label("Winner's Score: " + Integer.toString(score), 125);
        addObject(l, getWidth()/2, (getHeight()/2)-250);
    }
}