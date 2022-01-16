import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int direction;
    
    public Bullet(int direction){
        this.direction = direction;
    }
    
    public void act()
    {
        // Add your action code here.
        move(direction);
        if(getX() <= 0 || getX() >= 900){
            getWorld().removeObject(this);
        }
        if(isTouching(Pig.class)){
            getWorld().removeObject(this);
        }
    }
    
}
