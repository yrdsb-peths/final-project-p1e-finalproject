import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    
    int speed = 10;
    private int bulletDirection = 0;
    public static int direction = 0;
    /**
     * Act - do whatever the bullets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bullet(int direction){
        this.bulletDirection = direction;
    }
    
    public static void setDirection(int newDirection){
        direction = newDirection;
    }

    public void act()
    {
        // Add your action code here.
        if(this.bulletDirection > 0){
            move(5);
        } else {
            move(-5);
        }
        
        if(this.getX() <= 0 || this.getX() >= 1200){
            getWorld().removeObject(this);
        } else if (isTouching(Character.class)){
            
        }
    }
    
    public void updateScore(){
        Game.score.setValue(Game.points);
    }

}
