import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectile that player 2 will shoot out
 * 
 * @author Yoyo
 * @version 2022.01.20
 */
public class Bullet extends Actor
{
    // Default variables
    private int bulletDirection;
    private String playerDirection;
    
    private int speed = 5;
    private boolean startMove = false;
    GreenfootImage snakeShot = new GreenfootImage("snakebullet.png");
    
    // Bullet constructor
    public Bullet(int bulletDirection, String playerDirection){
        this.bulletDirection = bulletDirection;
        this.playerDirection = playerDirection;
        setImage(snakeShot);
    }
    
    // Getter and Setter
    public int getDirection(){
        return bulletDirection;
    }
    
    public void setDirection(int newDirection){
        bulletDirection = newDirection;
    }
    
     /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Remove bullet if out of world or touching pig 
        if(this.getX() <= 50 || this.getX() >= 1230){
            getWorld().removeObject(this);
        } else if(isTouching(Pig.class)){
            getWorld().removeObject(this);
            SoundEffects.hitByBulletSound();
            
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
