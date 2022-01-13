import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    int x = getWidth()/2;
    int y = getHeight()/2;
    
    //Score variables
    public static Label score;
    public static int points = 0;
    
    public static Label score2;
    public static int points2 = 0;
    
    Label player1Label;
    Label player2Label;
    
    //Character variables
    public static Character snake;
    public static Character pig;
    public static Character bear;
    
    public static Snake snakeClass;
    public static Pig pigClass;
    public static Bear bearClass;
    
    public static Character player1;
    public static Character player2;
    boolean oriented;
    
    public static ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        
        // Add two characers
        pigClass = new Pig();
        pig = new Character(pigClass, "w", "a", "s", "d", "g", "h");
        player1 = pig;
        addObject(pig, 462, 235);
        
        snakeClass = new Snake();
        snake = new Character(snakeClass, "up", "left", "down", "right", "o", "p");
        player2 = snake;
        addObject(snake, 800, 200);

        // Add scores
        score = new Label(0, 40);
        addObject(score, 100, 100);
        
        score2 = new Label(0, 40);
        addObject(score2, 1180, 100);
        
        player1Label = new Label("Player 1", 50);
        addObject(player1Label, 100, 50);
        
        player2Label = new Label("Player 2", 50);
        addObject(player2Label, 1180, 50);
        
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
    
    public void act(){
        orient();
        checkDeath();
        try{
            String keyPress = Greenfoot.getKey();
            if(keyPress.equals("space")){
                shootBullet();
            } else if (keyPress.equals("q")){
                inflatePig();
            }
        } catch (Exception NullPointerException){}
    }
    
    public void inflatePig(){
        pig.setLocation(400, 100);
        pig.getImage().scale(200, 200);
        pig.setImage(pig.getImage());
    }
    
    public void shootBullet(){
        if(snake.getX() < pig.getX()){
            Bullet b = new Bullet(1);
            bulletList.add(b);
            addObject(b, snake.getX(), snake.getY());
        } else {
            Bullet b = new Bullet(-1);
            bulletList.add(b);
            addObject(b, snake.getX(), snake.getY());
        }
    }
    
    public void checkDeath(){
        if(player1.getY() > 700){
            respawn(player1);
            points2++;
            score2.setValue(points2);
        }
        if(player2.getY() > 700){
            respawn(player2);
            points++;
            score.setValue(points);
        }
    }
    
    public void respawn(Character c){
        removeObject(c);
        addObject(c, 600, 200);
    }
    
    public void orient(){
        if(player1 == snake || player2 == snake){
            orientSnake();
        }
        if (player1 == pig || player2 == pig){
            orientPig();
        }

    }
    
    public void orientSnake(){
        if(player1 == snake){
            if(player1.getX() > player2.getX()){
                player1.setImage("snake2left.png");
                Bullet.setDirection(-1);
            } else {
                player1.setImage("snake2.png");
                Bullet.setDirection(1);
            }
        } else {
            if(player2.getX() < player1.getX()){
                player2.setImage("snake2.png");
                Bullet.direction = 1;
            } else {
                player2.setImage("snake2left.png");
                Bullet.setDirection(-1);
            }
        }
    }
    
    public void orientPig(){
        if(player1 == pig){
            if(player1.getX() > player2.getX()){
                player1.setImage("pigleft.png");
            } else {
                player1.setImage("pig.png");
            }
        } else {
            if(player2.getX() < player1.getX()){
                player2.setImage("pig.png");
            } else {
                player2.setImage("pigleft.png");
            }
        }
    }
}
