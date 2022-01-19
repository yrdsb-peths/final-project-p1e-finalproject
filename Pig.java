import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pig extends Character implements Playable
{
    // Movement variables
    private String id;
    private String up;
    private String left;
    private String down;
    private String right;
    private String auto;
    private String special;
    
    // Direction
    private String direction = "right";

    // Stocks
    public int stock = 3;
    
    private int originalHP = 4;
    private int HP = 4;
    private int SP = 1;
    private boolean alive = true;
    private boolean beingRespawned = false;
    private boolean startedDash = false;
    private boolean canUpdateSpecialBar = true;

    GreenfootImage imageRight = new GreenfootImage("pig.png");
    GreenfootImage imageLeft = new GreenfootImage("pig_left.png");
    
    SimpleTimer dashTimer = new SimpleTimer();
    private int dashTicker = 0;
    
    public Pig(String id, String up, String left, String down, String right, String auto, String special) {
        this.id = id;
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.auto = auto;
        this.special = special;
        setImage(imageRight);
    }

    /**
     * Act - do whatever the Pig wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        controls(id, up, left, down, right, auto, special, this);
        gravity();
        checkDash();
    }

    // Start auto attack
    public int auto() {
        dashTimer.mark();
        startedDash = true;
        canUpdateSpecialBar = true;
        return 1;
    }
    
    // Dash if player can dash
    public void checkDash(){
        // Check if can dash
        if(startedDash == true){
            // Start dash animation
            if(dashTimer.millisElapsed() % 1 == 0){
                dashTicker++;
                if(getImage() == imageRight){
                    move(10);
                } else {
                    move(-10);
                }
            }
            checkLandedHit();
            // Stops dash animation
            if(dashTicker >= 20){
                startedDash = false;
                dashTicker = 0;
            }
        }
    }
    
    // Check if dash hits opposing player
    public void checkLandedHit(){
        if(isTouching(Snake.class) && canUpdateSpecialBar == true){
            canUpdateSpecialBar = false;
            MyWorld.player2.setHP(MyWorld.player2.getHP() - 1);
            MyWorld.player2HPBar.setWidth(MyWorld.player2HPBar.getWidth() - 100);
            MyWorld.player1.setSpecial(MyWorld.player1.getSpecial() + 1);
            MyWorld.player1SpecialBar.setWidth(MyWorld.player1.getSpecial() + 1);
            if(getImage() == imageRight){
                MyWorld.player2.setLocation(getX() + 200, getY());
            } else {
                MyWorld.player2.setLocation(getX() - 200, getY());
            }
        }
    }

    public int special() {
        setLocation(getX(), getY() - 100);
        getImage().scale(200, 200);
        return 1;
    }

    public void direction(String direction) {
        if (direction.equals("left")) setImage(imageLeft);
        if (direction.equals("right")) setImage(imageRight);
    }
    
    // Getters and Setters
    public int getHP(){
        return HP;
    }
    
    public void setHP(int newHP){
        HP = newHP;
    }
    
    public boolean getAlive(){
        return alive;
    }
    
    public void setAlive(boolean newAlive){
        alive = newAlive;
    }
    
    public int getSpecial(){
        return SP;
    }
    
    public void setSpecial(int newSP){
        SP = newSP;
    }
    
    public boolean getStartedDash(){
        return startedDash;
    }
    
    public void setStartedDash(boolean newStartedDash){
        startedDash = newStartedDash;
    }
    
    public boolean getBeingRespawned(){
        return beingRespawned;
    }
    
    public void setBeingRespawned(boolean newBeingRespawned){
        beingRespawned = newBeingRespawned;
    }
}
