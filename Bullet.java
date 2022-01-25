import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectile that player 2 will shoot out
 * 
 * @author Yoyo
 * @version 2022.01.20
 */
public class Bullet extends Actor
{
    // Bullet variables
    private int bulletDirection;
    private String playerDirection;
    private int speed = 5;
    private boolean startMove = false;
    
    // Bullet constructor
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
    
    // Act method
    public void act()
    {
        // Remove bullet if no longer in the screen
        if(this.getX() <= 50 || this.getX() >= 1230){
            getWorld().removeObject(this);
        } else if(isTouching(Pig.class)){
            // Remove bullet if hit pig
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
            // Bullet travels
            move(speed * bulletDirection);
        }
    }
}
