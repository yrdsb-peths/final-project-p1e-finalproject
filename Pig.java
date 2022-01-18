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

    GreenfootImage imageRight = new GreenfootImage("pig.png");
    GreenfootImage imageLeft = new GreenfootImage("pig_left.png");
    
    public Pig(String up, String left, String down, String right, String auto, String special) {
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
        controls(up, left, down, right, auto, special, this);
        gravity();
    }

    public int auto() {
        /*if(getImage() == imageRight){
            move(100);
            if(isTouching(Snake.class)){
                MyWorld.player2.setLocation(MyWorld.player2.getX() + 200, MyWorld.player2.getY() - 50);
            }
        } else {
            move(-100);
            if(isTouching(Snake.class)){
                MyWorld.player2.setLocation(MyWorld.player2.getX() - 200, MyWorld.player2.getY() - 50);
            }
        }
        return 1;*/
        setLocation(getX(), getY() - 200);
        getImage().scale(100, 100);
        return 1;
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
    
    // Getter and Setter
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
    
    public boolean getBeingRespawned(){
        return beingRespawned;
    }
    
    public void setBeingRespawned(boolean newBeingRespawned){
        beingRespawned = newBeingRespawned;
    }
    
    public void hit(){
        if (isTouching(Bullet.class)) {
            
        }
    }
}
