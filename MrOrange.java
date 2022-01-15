import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MrOrange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MrOrange extends Character implements Playable
{
    // Movement variables
    private String up;
    private String left;
    private String down;
    private String right;
    private String auto;
    private String special;

    // Facing Direction
    private String direction = "left";

    public static GreenfootImage imageRight = new GreenfootImage("ppl3.png");
    public static GreenfootImage imageLeft = new GreenfootImage("ppl3_left.png");
    
    public MrOrange(String up, String left, String down, String right, String auto, String special) {
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.auto = auto;
        this.special = special;
    }

    /**
     * Act - do whatever the MrOrange wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        controls(up, left, down, right, auto, special, this);
        gravity();
    }

    public int auto() {
        System.out.println("Mr Orange autos!");
        return 1;
    }

    public int special() {
        System.out.println("Mr Orange uses special!");
        return 1;
    } 

    public void direction(String direction) {
        if (direction.equals("left")) setImage(imageLeft);
        if (direction.equals("right")) setImage(imageRight);
    }
}
