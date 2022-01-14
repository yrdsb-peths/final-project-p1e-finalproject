import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    int moveSpeed = 3;
    boolean inAir = false;
    int h = 415;
    
    /**
     * Act - do whatever the player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player()
    {
        
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void player1movement(GreenfootImage[] p1jump)
    {
        if(Greenfoot.isKeyDown("w") && inAir == false)
        {
            jump(p1jump);
            inAir = false;
        }
        if(Greenfoot.isKeyDown("a"))
        {
            this.setLocation(getX() - moveSpeed, getY());
        }
        if(Greenfoot.isKeyDown("s"))
        {
            
        }
        if(Greenfoot.isKeyDown("d"))
        {
            this.setLocation(getX() + moveSpeed, getY());
        }
    }
    
    public void jump(GreenfootImage[] x)
    {
        
        GreenfootImage standing = new GreenfootImage("p1idle1.png");
        standing.scale(30,90);
        int fakeGrav = 0;
        
        inAir = true;
        for(int i = 1; i < 3; i++)
        {
            x[i] = new GreenfootImage("p1jump" + i + ".png");
            x[i].scale(40,90);
            setImage(x[i]);
            Greenfoot.delay(4);
        }
        for(int i = 0; i < 5; i++)
        {
            setImage(standing);
            this.setLocation(getX(), getY() - (i * 15));
        }
        while(this.getY() < h)
        {
            this.setLocation(getX(), getY() + fakeGrav);
            fakeGrav++;
            Greenfoot.delay(1);
        }
        for(int i = 2; i < 0; i--)
        {
            x[i] = new GreenfootImage("p1jump" + i + ".png");
            x[i].scale(40,90);
            setImage(x[i]);
            Greenfoot.delay(4);
        }
        setImage(standing);
    }
}
