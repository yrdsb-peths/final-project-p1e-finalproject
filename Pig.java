import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player 1 - A playable character that uses movement as an attacks
 * 
 * @author Yoyo, Carl and Jayden
 * @version 2022.01.20
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
    
    // Direction - Spawns facing right
    private String direction = "right";

    // Default variables
    public int stock = 3;
    private int originalHP = 4;
    private int HP = 4;
    private int SP = 1;
    private boolean alive = true;
    private boolean beingRespawned = false;
    private boolean startedDash = false;
    private boolean startedSpecial = false;
    private boolean canUpdateSpecialBar = true;
    private boolean hitOnce = false;

    // Placeholder image variables
    public static GreenfootImage imageRight = new GreenfootImage("p1idleright.png");
    public static GreenfootImage imageLeft = new GreenfootImage("pig_left.png");
    public static GreenfootImage bigImageRight = new GreenfootImage("bigPig.png");
    public static GreenfootImage bigImageLeft = new GreenfootImage("bigPig_left.png");
    
    // Gif sprite animations
    public static GifImage p1IdleRight = new GifImage("p1idleright.gif");
    public static GifImage p1IdleLeft = new GifImage("p1idleleft.gif");
    public static GifImage p1PunchLeft = new GifImage("p1punchleft.gif");
    public static GifImage p1PunchRight = new GifImage("p1punchright.gif");
    
    // Timer variables
    private SimpleTimer dashTimer = new SimpleTimer();
    private SimpleTimer specialDashTimer = new SimpleTimer();
    private int dashTicker = 0;
    private int specialDashTicker = 0;
    private SimpleTimer animTimer = new SimpleTimer();
    
    // Animation variables
    boolean startedAnim = false;
    int autoFrame = 0;
    
    // Act method booleans
    private boolean facingRight = true;
    private boolean punch = false;
    
    /**
     * Constructor for objects of class Pig
     */
    public Pig(String up, String left, String down, String right, String auto, String special) {
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.auto = auto;
        this.special = special;
        setImage(imageRight);
        //this.getImage().scale(50, 50);
        //idleAnimationRescale();
    }

    /**
     * Act - do whatever the Pig wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animations();
        controls(up, left, down, right, auto, special, this);
        gravity();
        checkDash();
        checkSpecialDash();
    }
    
    // All animations
    public void animations()
    {
        if(startedAnim == true){
            // Play punch animation if pig is dashing
            if(punch == true && facingRight == true){
                if(autoFrame < 5){
                    if(animTimer.millisElapsed() > 100){
                        setImage(p1PunchRight.getImages().get(autoFrame));
                        autoFrame++;
                        animTimer.mark();
                    }
                } else {
                    punch = false;
                    autoFrame = 0;
                    startedAnim = false;
                }
            } else if(punch == true && facingRight == false){
                if(autoFrame < 5){
                    if(animTimer.millisElapsed() > 100){
                        setImage(p1PunchLeft.getImages().get(autoFrame));
                        autoFrame++;
                        animTimer.mark();
                    }
                } else {
                    punch = false;
                    autoFrame = 0;
                    startedAnim = false;
                }
            }
        } else {
            // Play idle animation if pig isn't dashing
            if(facingRight == true){
                setImage(p1IdleRight.getCurrentImage());
            }
            else
            {
                setImage(p1IdleLeft.getCurrentImage());
            }
        }
    }
    
    // Resize all frames of idle animation
    public void idleAnimationRescale() {
        int scalePercent = 100;
        for(GreenfootImage image : p1IdleRight.getImages()) {
            int wide = image.getWidth()*scalePercent/100;
            int high = image.getHeight()*scalePercent/100;
            image.scale(50, 50);
        }
        for(GreenfootImage image : p1IdleLeft.getImages()) {
            int wide = image.getWidth()*scalePercent/100;
            int high = image.getHeight()*scalePercent/100;
            image.scale(50, 50);
        }
        for(GreenfootImage image : p1PunchRight.getImages()){
            image.scale(50, 50);
        }
        for(GreenfootImage image : p1PunchLeft.getImages()){
            image.scale(50, 50);
        }
    }
    
    // Resize all frames of special animation
    public void specialAnimationRescale() {
        int scalePercent = 200;
        for(GreenfootImage image : p1IdleRight.getImages()) {
            image.scale(100, 100);
        }
        for(GreenfootImage image : p1IdleLeft.getImages()) {
            image.scale(100, 100);
        }
        for(GreenfootImage image : p1PunchRight.getImages()){
            image.scale(100, 100);
        }
        for(GreenfootImage image : p1PunchLeft.getImages()){
            image.scale(100, 100);
        }
    }
    
    // Start auto attack
    public int auto() {
        punch = true;
        dashTimer.mark();
        startedDash = true;
        canUpdateSpecialBar = true;
        SoundEffects.dashAutoSound();
        return 1;
    }
    
    // Dash if player can dash
    public void checkDash(){
        // Check if can dash
        if(startedDash == true){
            if(startedAnim == false){
                startedAnim = true;
                animTimer.mark();
            }
            // Start dash
            if(dashTimer.millisElapsed() % 1 == 0){
                dashTicker++;
                if(facingRight == true){
                    move(10);
                    if (this.isTouching(PlatformYL.class)) move(-15);
                } else {
                    move(-10);
                    if (this.isTouching(PlatformYR.class)) move(15);
                }
            }
            checkLandedHit();
            // Stops dash
            if(dashTicker >= 20){
                startedDash = false;
                hitOnce = false;
                dashTicker = 0;
            }
        }
    }
    
    // Dash if player can special dash
    public void checkSpecialDash(){
        // Check if can special dash
        if(startedSpecial == true){
            // Start dash animation
            specialAnimationRescale();
            if(startedAnim == false){
                startedAnim = true;
                animTimer.mark();
            }
            if(specialDashTimer.millisElapsed() % 1 == 0){
                specialDashTicker++;
                if(facingRight){
                    move(15);
                    if (this.isTouching(PlatformYL.class)) move(-15);
                } else {
                    move(-15);
                    if (this.isTouching(PlatformYR.class)) move(15);
                }
            }
            checkLandedHit();
            // Stops dash animation
            if(specialDashTicker >= 15){
                hitOnce = false;
                startedSpecial = false;
                specialDashTicker = 0;
                idleAnimationRescale();
                if(getImage() == bigImageRight){
                    setImage(imageRight);
                } else if(getImage() == bigImageLeft){
                    setImage(imageLeft);
                }
            }
        }
    }
    
    // Check if dash hits opposing player
    public void checkLandedHit(){
        if(isTouching(Snake.class)){
            // Changes special bar value if applicable
            if(canUpdateSpecialBar == true){
                canUpdateSpecialBar = false;
                SoundEffects.hitByDashSound();
                MyWorld.player2.setHP(MyWorld.player2.getHP() - 1);
                MyWorld.player2HPBar.setWidth(MyWorld.player2HPBar.getWidth() - 100);
                MyWorld.player1.setSpecial(MyWorld.player1.getSpecial() + 1);
                MyWorld.player1SpecialBar.setWidth(MyWorld.player1.getSpecial() + 1);
            }
            
            // Knockback the snake if hit
            if(hitOnce == false){
                hitOnce = true;
                /*if(getImage() == imageRight || getImage() == bigImageRight){
                    MyWorld.player2.setLocation(getX() + 200, getY());
                } else if(getImage() == imageLeft || getImage() == bigImageLeft){
                    MyWorld.player2.setLocation(getX() - 200, getY());
                } else if(getImage() == bigImageLeft){
                    MyWorld.player2.setLocation(getX() + 300, getY() + 100);
                } else if(getImage() == bigImageRight){
                    MyWorld.player2.setLocation(getX() - 300, getY() + 100);
                }*/
                for(GreenfootImage image : p1IdleRight.getImages()) {
                    if(getImage() == image){
                        MyWorld.player2.setLocation(getX() + 200, getY());
                        break;
                    }
                }
                for(GreenfootImage image : p1IdleLeft.getImages()) {
                    if(getImage() == image){
                        MyWorld.player2.setLocation(getX() - 200, getY());
                        break;
                    }
                }
                for(GreenfootImage image : p1PunchRight.getImages()) {
                    if(getImage() == image){
                        MyWorld.player2.setLocation(getX() + 200, getY());
                        break;
                    }
                }
                for(GreenfootImage image : p1PunchLeft.getImages()) {
                    if(getImage() == image){
                        MyWorld.player2.setLocation(getX() - 200, getY());
                        break;
                    }
                }
            }
        }
    }

    // Start special attack
    public int special() {
        specialDashTimer.mark();
        punch = true;
        startedSpecial = true;
        SP = 0;
        MyWorld.player2SpecialBar.setWidth(2);
        SoundEffects.dashSpecialSound();
        return 1;
    }

    // Changes direction of pig through facingRight boolean
    public void direction(String direction) {
        if (direction.equals("left")){
            facingRight = false;
        }
        if (direction.equals("right")){
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
