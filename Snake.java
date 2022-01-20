import greenfoot.*;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Character implements Playable
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
    private String direction = "left";

    // Stocks
    public int stock = 3;
    
    private int originalHP = 4;
    private int HP = 4;
    private int SP = 1;
    private boolean alive = true;
    private boolean beingRespawned = false;
    private boolean isHit = false;

    GreenfootImage imageRight = new GreenfootImage("snake.png");
    GreenfootImage imageLeft = new GreenfootImage("snake_left.png");

    /**
     * Constructor for objects of class Snake
     */
    public Snake(String id, String up, String left, String down, String right, String auto, String special) {
        this.id = id;
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.auto = auto;
        this.special = special;
        setImage(imageLeft);
    }

    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        controls(id, up, left, down, right, auto, special, this);
        gravity();
        checkHit();
        checkAlive();
    }

    public int auto() {
        Bullet b;
        if(getImage() == imageLeft){
            b = new Bullet(-1, direction);
            b.getImage().scale(20, 20);
            getWorld().addObject(b, this.getX() - 50, this.getY());
        } else {
            b = new Bullet(1, direction);
            b.getImage().scale(20, 20);
            getWorld().addObject(b, this.getX() + 50, this.getY());
        }
        
        return 1;
    }

    public int special() {
        Bullet b;
        if(getImage() == imageLeft){
            b = new Bullet(-10, direction);
            b.getImage().scale(200, 200);
            getWorld().addObject(b, this.getX() - 100, this.getY());
        } else {
            b = new Bullet(10, direction);
            b.getImage().scale(200, 200);
            getWorld().addObject(b, this.getX() + 100, this.getY());
        }
        SP = 0;
        MyWorld.player2SpecialBar.setWidth(2);
        return 1;
    }
    
    // Check if hit by pig dash
    public void checkHit(){
        if(MyWorld.player1.getStartedDash() == true){
            if(isTouching(Pig.class)){
                /*MyWorld.player2.setHP(MyWorld.player2.getHP() - 1);
                MyWorld.player2HPBar.setWidth(MyWorld.player2HPBar.getWidth() - 100);
                MyWorld.player1.setSpecial(MyWorld.player1.getSpecial() + 1);
                MyWorld.player1SpecialBar.setWidth(MyWorld.player1.getSpecial() + 1);*/
            }
        }
    }

    public void direction(String direction) {
        this.direction = direction;
        if (direction.equals("left")) setImage(imageLeft);
        if (direction.equals("right")) setImage(imageRight);
    }
    
    private void checkAlive() {
        if (!alive) {
            imageRight.setTransparency(0);
            imageLeft.setTransparency(0);
        }
        else {
            imageRight.setTransparency(255);
            imageLeft.setTransparency(255);
        }
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
    
    public boolean getIsHit(){
        return isHit;
    }
    
    public void setIsHit(boolean newIsHit){
        isHit = newIsHit;
    }
    
    public boolean getBeingRespawned(){
        return beingRespawned;
    }
    
    public void setBeingRespawned(boolean newBeingRespawned){
        beingRespawned = newBeingRespawned;
    }
}
