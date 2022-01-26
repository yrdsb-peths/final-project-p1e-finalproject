import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Main game world
 * 
 * @author Yoyo and Carl
 * @version 2022.01.20
 */
public class MyWorld extends World
{
    // Middle dimensions
    int x = getWidth()/2;
    int y = getHeight()/2;
 
    // Players
    public static Pig player1;
    public static Snake player2; 

    // Player stocks
    int oneStock = 3; 
    int twoStock = 3;
    
    // Respawn variables
    boolean playingPlayer1RespawnSound = false;
    boolean playingPlayer2RespawnSound = false;
    
    // HP bar variables
    public static HPBar player1HPBar;
    public static HPBar player2HPBar;
    Label player1HPLabel;
    Label player2HPLabel;
    HPBarEmpty player1HPBarEmpty;
    HPBarEmpty player2HPBarEmpty;
    
    // Hearts variables
    ArrayList<Heart> player1Hearts = new ArrayList<Heart>();
    ArrayList<Heart> player2Hearts = new ArrayList<Heart>();
    
    // Special bar variables
    public static SpecialBar player1SpecialBar;
    public static SpecialBar player2SpecialBar;
    Label player1SpecialBarLabel;
    Label player2SpecialBarLabel;
    
    // Timer variables
    SimpleTimer minTimer;
    SimpleTimer secTimer;
    SimpleTimer player1RespawnTimer;
    SimpleTimer player2RespawnTimer;
    SimpleTimer scoreTimer = new SimpleTimer();
    
    // Label variables
    Label minLabel;
    Label secLabel;
    Label colonLabel;
    Label player1Label;
    Label player2Label;
    int currentMins;
    int currentSecs;
    int flashDelay = 500;
    boolean startedFlash = false;
    SimpleTimer flashTimer;

    public void act() {
        updateTimer();
        // Check if Player 1 needs to be respawned
        if(player1.getBeingRespawned() == false){
            // Check if touching edge or if no HP left
            if (player1.isAtEdge() || player1.getHP() <= 0) {
                // Respawn if Player 1 has lives remaining, end game if no lives left
                if (oneStock > 0) {
                    SoundEffects.deathSound();
                    player1.setAlive(false);
                    player1.setBeingRespawned(true);
                    oneStock--;
                    
                    // Update HP graphics
                    player1.setHP(0);
                    player1HPBar.getImage().setTransparency(0);
                    removeObject(player1Hearts.get(player1Hearts.size() - 1));
                    player1Hearts.remove(player1Hearts.size() - 1);
                    
                    makePlayer1Invisible();
                    player1RespawnTimer.mark();
                }
                else gameOver(player1);
            }
        } else {
            // Wait 2 seconds to play respawn sound
            if(player1RespawnTimer.millisElapsed() > 1500){
                if(playingPlayer1RespawnSound == false){
                    SoundEffects.respawnSound();
                    playingPlayer1RespawnSound = true;
                }
            }
            
            // Wait 3 seconds to respawn player 1
            if(player1RespawnTimer.millisElapsed() > 3000){
                // Reset all variables
                player1.setLocation(x, y);
                makePlayer1Visible();
                player1.setHP(4);
                player1HPBar.setWidth(400);
                player1HPBar.getImage().setTransparency(255);
                player1HPBar.setLocation(220, 100);
                player1.setAlive(true);
                player1.setBeingRespawned(false);
                playingPlayer1RespawnSound = false;
            }
        }
        
        // Check if Player 2 needs to be respawned
        if(player2.getBeingRespawned() == false){
            // Check if touching edge or if no HP left
            if (player2.isAtEdge() || player2.getHP() <= 0) {
                // Respawn if Player 2 has lives remaining, end game if no lives left
                if (twoStock > 0) {
                    SoundEffects.deathSound();
                    player2.setAlive(false);
                    player2.setBeingRespawned(true);
                    twoStock--;
                    
                    // Update HP graphics
                    player2.setHP(0);
                    player2HPBar.getImage().setTransparency(0);
                    removeObject(player2Hearts.get(player2Hearts.size() - 1));
                    player2Hearts.remove(player2Hearts.size() - 1);
                    
                    makePlayer2Invisible();
                    player2RespawnTimer.mark();
                }
                else gameOver(player2);
            }
        } else {
            // Wait 2 seconds to play respawn sound
            if(player2RespawnTimer.millisElapsed() > 1500){
                if(playingPlayer2RespawnSound == false){
                    SoundEffects.respawnSound();
                    playingPlayer2RespawnSound = true;
                }
            }
            // Wait 3 seconds to respawn player 2
            if(player2RespawnTimer.millisElapsed() > 3000){
                // Reset all variables
                player2.setLocation(x, y);
                makePlayer2Visible();
                player2.setHP(4);
                player2HPBar.setWidth(400);
                player2HPBar.getImage().setTransparency(255);
                player2HPBar.setLocation(1050, 100);
                player2.setAlive(true);
                player2.setBeingRespawned(false);
                playingPlayer2RespawnSound = false;
            }
        }
    }
    
    // Ends game and shows scores world
    public void gameOver(Character actor) {
        if (oneStock == 0) { 
            actor.getImage().setTransparency(0);
            Greenfoot.setWorld(new ScoresWorld(2, scoreTimer.millisElapsed()));
        }
        else { 
            actor.getImage().setTransparency(0);
            Greenfoot.setWorld(new ScoresWorld(1, scoreTimer.millisElapsed()));
        }
    }
    
    // Various methods to set transparencies of all images of characters
    public void makePlayer1Invisible(){
        for(GreenfootImage image : player1.p1IdleRight.getImages()) {
            image.setTransparency(0);
        }
        for(GreenfootImage image : player1.p1IdleLeft.getImages()) {
            image.setTransparency(0);
        }
        for(GreenfootImage image : player1.p1PunchRight.getImages()) {
            image.setTransparency(0);
        }
        for(GreenfootImage image : player1.p1PunchLeft.getImages()) {
            image.setTransparency(0);
        }
    }
    
    public void makePlayer1Visible(){
        for(GreenfootImage image : player1.p1IdleRight.getImages()) {
            image.setTransparency(255);
        }
        for(GreenfootImage image : player1.p1IdleLeft.getImages()) {
            image.setTransparency(255);
        }
        for(GreenfootImage image : player1.p1PunchRight.getImages()) {
            image.setTransparency(255);
        }
        for(GreenfootImage image : player1.p1PunchLeft.getImages()) {
            image.setTransparency(255);
        }
    }
    
    public void makePlayer2Invisible(){
        for(GreenfootImage image : player2.p2IdleRight.getImages()) {
            image.setTransparency(0);
        }
        for(GreenfootImage image : player2.p2IdleLeft.getImages()) {
            image.setTransparency(0);
        }
        for(GreenfootImage image : player2.p2PunchRight.getImages()) {
            image.setTransparency(0);
        }
        for(GreenfootImage image : player2.p2PunchLeft.getImages()) {
            image.setTransparency(0);
        }
    }
    
    public void makePlayer2Visible(){
        for(GreenfootImage image : player2.p2IdleRight.getImages()) {
            image.setTransparency(255);
        }
        for(GreenfootImage image : player2.p2IdleLeft.getImages()) {
            image.setTransparency(255);
        }
        for(GreenfootImage image : player2.p2PunchRight.getImages()) {
            image.setTransparency(255);
        }
        for(GreenfootImage image : player2.p2PunchLeft.getImages()) {
            image.setTransparency(255);
        }
    }

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {   
        // "up", "left", "down", "right", "n", "m"
        // "w", "a", "s", "d", "g", "h"
        super(1280, 720, 1); 
        prepare();
        setBackground(new GreenfootImage("gamebackground.jpg"));
        
        // Timers
        minTimer = new SimpleTimer();
        minTimer.mark();
        secTimer = new SimpleTimer();
        secTimer.mark();
        player1RespawnTimer = new SimpleTimer();
        player2RespawnTimer = new SimpleTimer();
        
        // Add elements to world
        addBars();
        addLabels();
        addHearts();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addBackground(new MainBackground());

        // Add players
        player1 = new Pig("w", "a", "s", "d", "g", "h");
        addObject(player1,640-200,410);
        player2 = new Snake("up", "left", "down", "right", "n", "m");
        addObject(player2,640+200,410);
        makePlayer1Visible();
        makePlayer2Visible();
        
        addBackground(new MainBackgroundR());
        addBackground(new MainBackgroundL());
        PlatformX platformX = new PlatformX();
        addObject(platformX,640,485);
        PlatformYL platformYL = new PlatformYL();
        addObject(platformYL,330,591);
        PlatformYR platformYR = new PlatformYR();
        addObject(platformYR,948,589);
        PlatformSmall platformSmall = new PlatformSmall();
        addObject(platformSmall,640,312);
    }
    
    // Helper method to add background assests because typing on a laggy greenfoot editor
    // does NOT help my nerves
    private void addBackground(Background x) {
        addObject(x, 640, 500);
    }
    
    // Add labels to the game
    public void addLabels(){
        // Add player name labels
        player1Label = new Label("Player 1", 50);
        addObject(player1Label, 100, 50);
        player2Label = new Label("Player 2", 50);
        addObject(player2Label, 1180, 50);
        
        // Add HP labels
        player1HPLabel = new Label("HP", 20);
        addObject(player1HPLabel, 35, 100);
        player2HPLabel = new Label("HP", 20);
        addObject(player2HPLabel, 1235, 100);
        
        // Add Special Labels
        player1SpecialBarLabel = new Label("Ultimate", 20);
        addObject(player1SpecialBarLabel, 55, 120);
        player2SpecialBarLabel = new Label("Ultimate", 20);
        addObject(player2SpecialBarLabel, 1215, 120);
        
        // Add timer labels
        currentMins = 1;
        currentSecs = 11;
        minLabel = new Label(currentMins, 70);
        secLabel = new Label(currentSecs, 70);
        colonLabel = new Label(":", 70);
        addObject(minLabel, 600, 50);
        addObject(secLabel, 700, 50);
        addObject(colonLabel, 650, 50);
        
        // Initiate flash variables for timer labels
        startedFlash = false;
        flashTimer = new SimpleTimer();
    }
    
    // Add needed rectangular bars to game
    private void addBars(){
        // HP Bars
        player1HPBarEmpty = new HPBarEmpty();
        addObject(player1HPBarEmpty, 220, 100);
        player2HPBarEmpty = new HPBarEmpty();
        addObject(player2HPBarEmpty, 1050, 100);
        player1HPBar = new HPBar("one");
        addObject(player1HPBar, 220, 100);
        player2HPBar = new HPBar("two");
        addObject(player2HPBar, 1050, 100);
        
        // Special Bars
        player1SpecialBar = new SpecialBar("one");
        addObject(player1SpecialBar, 45, 120);
        player2SpecialBar = new SpecialBar("two");
        addObject(player2SpecialBar, 1225, 120);
    }
    
    // Add hearts to screen
    private void addHearts(){
        for(int i = 0; i < 4; i++){
            Heart h1 = new Heart();
            player1Hearts.add(h1);
            addObject(h1, 220 + i * 50, 50);
            Heart h2 = new Heart();
            player2Hearts.add(h2);
            addObject(h2, 1060 - i * 50, 50);
        }
    }
    
    // Updates the timer at the top of the screen
    private void updateTimer(){
        if(secTimer.millisElapsed() > 1000){
            currentSecs--;
            if(currentSecs == -1){
                currentMins--;
                minLabel.setValue(currentMins);
                minTimer.mark();                
            }
            if(currentSecs < 0){
                currentSecs = 59;
            }
            
            // Flash timer red and orange once there are ten seconds left
            if(currentSecs < 11 && currentMins < 1){
                if(startedFlash == false){
                    startedFlash = true;
                    flashTimer.mark();
                }
                if(flashTimer.millisElapsed() > flashDelay){
                    flashTimer.mark();
                    if(minLabel.getFillColor() == Color.RED){
                        minLabel.setFillColor(Color.ORANGE);
                        colonLabel.setFillColor(Color.ORANGE);
                        secLabel.setFillColor(Color.ORANGE);
                    } else {
                        minLabel.setFillColor(Color.RED);
                        colonLabel.setFillColor(Color.RED);
                        secLabel.setFillColor(Color.RED);
                    }
                }
            }
            // Add a 0 in front of single digit seconds
            if(currentSecs < 10){
                secLabel.setValue("0" + currentSecs);
            } else {
                secLabel.setValue(currentSecs);
            }
            secTimer.mark();
        }
        
        // Game over when time reaches 0
        if(currentSecs == 0 && currentMins == 0){
            Greenfoot.setWorld(new ScoresWorld(0, scoreTimer.millisElapsed()));
        }
    }
}
