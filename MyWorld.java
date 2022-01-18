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
    public static Pig player1;
    public static Snake player2; 

    // Player stocks
    int oneStock = 3;
    int twoStock = 3;
    
    Label player1Label;
    Label player2Label;
    
    // HP bar variables
    public static HPBar player1HPBar;
    public static HPBar player2HPBar;
    Label player1HPLabel;
    Label player2HPLabel;
    HPBarEmpty player1HPBarEmpty;
    HPBarEmpty player2HPBarEmpty;
    
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
    
    Label minLabel;
    Label secLabel;
    Label colonLabel;
    
    int currentMins;
    int currentSecs;

    public void act() {
        updateTimer();
        try {
            if (player1.isAtEdge() && player1.getBeingRespawned() == false) {
                if (oneStock > 0) {
                    player1.setAlive(false);
                    player1.setBeingRespawned(true);
                    oneStock--;
                    startRespawn();
                }
                else gameOver(player1);
            }
            if (player2.isAtEdge() && player2.getBeingRespawned() == false) {
                if (twoStock > 0) {
                    player2.setAlive(false);
                    player2.setBeingRespawned(true);
                    twoStock--;
                    startRespawn();
                }
                else gameOver(player2);
            }
            
            if(player1.getHP() <= 0){
                player1.getImage().setTransparency(0);
                respawnPlayer1();
                player1.setHP(4);
            }
            
            // Checks if enough time has passed before characters respawn
            if(player1.getBeingRespawned() == true){
                if(player1RespawnTimer.millisElapsed() > 3000){
                    respawnPlayer1();
                    player1.setBeingRespawned(false);
                }
            }
            if(player2.getBeingRespawned() == true){
                if(player2RespawnTimer.millisElapsed() > 3000){
                    respawnPlayer2();
                    player2.setBeingRespawned(false);
                }
            }
        }
        catch (Exception e){} // Change world
    }

    public void gameOver(Character actor) {
        /*if (oneStock == 0) { 
            removeObject(actor);
            System.out.println("Player 2 wins");
        }
        else { 
            removeObject(actor);
            System.out.println("Player 1 wins");
        }*/
    }

    // Respawn a character in the middle of the world
    public void respawn(Character actor) {
        actor.setLocation(x,y);
        actor.getImage().setTransparency(255);
    }
    
    private void respawnPlayer1(){
        player1.setLocation(x, y);
        player1.setAlive(true);
        player1.getImage().setTransparency(255);
    }
    
    private void respawnPlayer2(){
        player2.setLocation(x, y);
        player2.setAlive(true);
        player2.getImage().setTransparency(255);
    }
    
    // Start respawn timer if a player dies
    private void startRespawn(){
        if(player1.getAlive() == false){
            player1.getImage().setTransparency(0);
            player1RespawnTimer.mark();
        }
        if(player2.getAlive() == false){
            player2.getImage().setTransparency(0);
            player2RespawnTimer.mark();
        }
    }

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        // "up", "left", "down", "right", "n", "m"
        // "w", "a", "s", "d", "g", "h"
        super(1280, 720, 1); 
        
        // Add players to world
        player1 = new Pig("w", "a", "s", "d", "g", "h");
        player2 = new Snake("up", "left", "down", "right", "n", "m");
        addObject(player1, 462, 435);
        addObject(player2, 900, 425);
        
        // Timers
        minTimer = new SimpleTimer();
        minTimer.mark();
        secTimer = new SimpleTimer();
        secTimer.mark();
        player1RespawnTimer = new SimpleTimer();
        player2RespawnTimer = new SimpleTimer();
        
        addBars();
        addLabels();
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
    
    // Add labels to the game
    private void addLabels(){
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
            if(currentSecs < 10){
                secLabel.setValue("0" + currentSecs);
            } else {
                secLabel.setValue(currentSecs);
            }
            secTimer.mark();
        }
        
        // Game over when time reaches 0
        if(currentSecs == 0 && currentMins < 0){
            Greenfoot.setWorld(new GameOver());
        }
    }
}
