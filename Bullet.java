import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectile that player 2 will shoot out
 * 
 * @author Yoyo
 * @version 2022.01.20
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int bulletDirection;
    private String playerDirection;
    
    private int speed = 5;
    private boolean startMove = false;
    
    public Bullet(int bulletDirection, String playerDirection){
        this.bulletDirection = bulletDirection;
        this.playerDirection = playerDirection;
    }
    
    // Getter and Setter
    public int getDirection(){
        return bulletDirection;
    }
    
    public void setDirection(int newDirection){
        bulletDirection = newDirection;
    }
    
    public void act()
    {
        if(this.getX() <= 50 || this.getX() >= 1230){
            getWorld().removeObject(this);
        } else if(isTouching(Pig.class)){
            getWorld().removeObject(this);
            
            // Update player bars
            MyWorld.player1.setHP(MyWorld.player1.getHP() - 1);
            MyWorld.player1HPBar.setWidth(MyWorld.player1HPBar.getWidth() - 100);
            MyWorld.player2.setSpecial(MyWorld.player2.getSpecial() + 1);
            MyWorld.player2SpecialBar.setWidth(MyWorld.player2.getSpecial() + 1);
            
            // Change bar location based on new bar size
            if(bulletDirection < 0){
                MyWorld.player1.setLocation(MyWorld.player1.getX() - 80, MyWorld.player1.getY());
            } else {
                MyWorld.player1.setLocation(MyWorld.player1.getX() + 80, MyWorld.player1.getY());
            }
        } else {
            // Travel
            move(speed * bulletDirection);
        }
    }
}
