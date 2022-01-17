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
    private int bulletDirection;
    private String playerDirection;
    
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
        } else if(playerDirection.equals("left") && isTouching(Pig.class)){
            getWorld().removeObject(this);
            
            MyWorld.player1.setLocation(MyWorld.player1.getX() - 80, MyWorld.player1.getY());
            
            MyWorld.player1.setHP(MyWorld.player1.getHP() - 1);
            MyWorld.player1HPBar.setWidth(MyWorld.player1HPBar.getWidth() - 100);
            MyWorld.player2.setSpecial(MyWorld.player2.getSpecial() + 1);
            MyWorld.player2SpecialBar.setWidth(MyWorld.player2.getSpecial() + 1);
        } else if(playerDirection.equals("right") && isTouching(Pig.class)){
            getWorld().removeObject(this);
            
            MyWorld.player1.setLocation(MyWorld.player1.getX() + 80, MyWorld.player1.getY());
            
            MyWorld.player1.setHP(MyWorld.player1.getHP() - 1);
            MyWorld.player1HPBar.setWidth(MyWorld.player1HPBar.getWidth() - 100);
            MyWorld.player2.setSpecial(MyWorld.player2.getSpecial() + 1);
            MyWorld.player2SpecialBar.setWidth(MyWorld.player2.getSpecial() + 1);
        } else {
            move(bulletDirection);
        }
    }
}
