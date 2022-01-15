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

    GreenfootImage imageRight = new GreenfootImage("pig.png");
    GreenfootImage imageLeft = new GreenfootImage("pig_left.png");
    
    public Pig(String up, String left, String down, String right, String auto, String special) {
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.auto = auto;
        this.special = special;
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
        System.out.println("Pig attacks!");
        Greenfoot.delay(100);
        return 1;
    }

    public int special() {
        System.out.println("Pig uses special!");
        return 1;
    }

    public void direction(String direction) {
        if (direction.equals("left")) setImage(imageLeft);
        if (direction.equals("right")) setImage(imageRight);
    }
}
