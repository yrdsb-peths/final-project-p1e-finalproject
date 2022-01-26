import greenfoot.*;
/**
 * Player 2 - Character that attacks using ranged abilities at the cost of low mobility
 * 
 * @author Yoyo, Carl and Jayden
 * @version 2022.01.20
 */
public class Snake extends Character implements Playable
{
    // Movement variables
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
    private boolean rescaledImages = false;
    
    public static GreenfootImage imageRight = new GreenfootImage("snake.png");
    public static GreenfootImage imageLeft = new GreenfootImage("snake_left.png");
    public static GifImage p2IdleLeft = new GifImage("snakeidle.gif");
    public static GifImage p2IdleRight = new GifImage("snakeidle2.gif");
    public static GifImage p2PunchLeft = new GifImage("snakepunchleft.gif");
    public static GifImage p2PunchRight = new GifImage("snakepunchright.gif");
    
    // Animation variables
    private boolean startedAnim = false;
    private boolean startedShoot = false;
    private int autoFrame = 0;
    private SimpleTimer animTimer = new SimpleTimer();
    private SimpleTimer fillerTimer = new SimpleTimer();
    private int fillerInt = 0;
    
    // Act method booleans
    private boolean facingRight = false;
    private boolean shoot = false;
    private boolean endedShoot = false;
        
    /**
     * Constructor for objects of class Snake
     */
    public Snake(String up, String left, String down, String right, String auto, String special) {
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.auto = auto;
        this.special = special;
        setImage(imageLeft);
        if(rescaledImages == false){
            rescaledImages = true;
            for(GreenfootImage image : p2IdleRight.getImages()) {
                image.scale(50, 50);
            }
            for(GreenfootImage image : p2IdleLeft.getImages()) {
                image.scale(50, 50);
            }
            for(GreenfootImage image : p2PunchRight.getImages()){
                image.scale(50, 50);
            }
            for(GreenfootImage image : p2PunchLeft.getImages()){
                image.scale(50, 50);
            }
        }
    }

    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animations();
        controls(up, left, down, right, auto, special, this);
        gravity();
    }

    public void animations()
    {
        if(facingRight == true){
            setImage(p2IdleRight.getCurrentImage());
        }
        else
        {
            setImage(p2IdleLeft.getCurrentImage());
        }
    }
    
    public int auto() {
        Bullet b;
        if(facingRight == false){
            b = new Bullet(-1, direction);
            b.getImage().scale(20, 20);
            getWorld().addObject(b, this.getX() - 50, this.getY());
            setLocation(getX() + 50, getY());
        } else {
            b = new Bullet(1, direction);
            b.getImage().scale(20, 20);
            getWorld().addObject(b, this.getX() + 50, this.getY());
            setLocation(getX() - 50, getY());
        }
        
        SoundEffects.shootAutoSound();
        return 1;
    }

    public int special() {
        Bullet b;
        if(facingRight == false){
            b = new Bullet(-2, direction);
            b.getImage().scale(200, 200);
            getWorld().addObject(b, this.getX() - 100, this.getY());
        } else {
            b = new Bullet(2, direction);
            b.getImage().scale(200, 200);
            getWorld().addObject(b, this.getX() + 100, this.getY());
        }
        
        SP = 0;
        MyWorld.player2SpecialBar.setWidth(2);
        SoundEffects.shootSpecialSound();
        return 1;
    }

    /*public void direction(String direction) {
        this.direction = direction;
        if (direction.equals("left")) {
            setImage(imageLeft);
            facingRight = false;
        }
        if (direction.equals("right")) {
            setImage(imageRight);
            facingRight = true;
        }
    }*/
    
    public void direction(String direction) {
        if (direction.equals("left")){
            //direction = "left";
            facingRight = false;
        }
        if (direction.equals("right")){
            //direction = "right";
            facingRight = true;
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
