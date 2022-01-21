import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    int moveSpeed = 10;
    boolean inAir = false;
    int h = 415;
    boolean idle = true;
    
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
    
    public void player1movement(GreenfootImage[] p1jump, GreenfootImage p1idle, GreenfootImage run1, GreenfootImage run2)
    {
        if(Greenfoot.isKeyDown("w") && inAir == false)
        {
            jump(p1jump, p1idle,1);
            inAir = false;
        }
        if(Greenfoot.isKeyDown("a"))
        {
            this.setLocation(getX() - moveSpeed, getY());
            run(run1,run2);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            
        }
        if(Greenfoot.isKeyDown("d"))
        {
            run(run1,run2);
            this.setLocation(getX() + moveSpeed, getY());
        }
    }
    
    public void player2movement(GreenfootImage[] p2jump, GreenfootImage p2idle, GreenfootImage run1, GreenfootImage run2, GreenfootImage run3, GreenfootImage run4)
    {
        if(Greenfoot.isKeyDown("up") && inAir == false)
        {
            jump(p2jump,p2idle,2);
            inAir = false;
        }
        while(Greenfoot.isKeyDown("left"))
        {
            run(run1,run2);
            this.setLocation(getX() - moveSpeed, getY());
        }
        if(Greenfoot.isKeyDown("down"))
        {
            
        }
        while(Greenfoot.isKeyDown("right"))
        {
            run(run3,run4);
            this.setLocation(getX() + moveSpeed, getY());
        }
    }
    
    public void idle(GreenfootImage f1, GreenfootImage f2)
    {
        setImage(f1);
        Greenfoot.delay(20);
        setImage(f2);
        Greenfoot.delay(20);
    }
    
    public void jump(GreenfootImage[] jumping, GreenfootImage idle, int player)
    {
        
        int fakeGrav = 0;
        
        int width = 40;
        int height = 90;
        
        if(player == 2)
        {
            width = 105;
            height = 115;
        }
        
        
        inAir = true;
        for(int i = 1; i < 12; i++)
        {
            jumping[i] = new GreenfootImage("p" + player + "jump" + i + ".png");
            jumping[i].scale(width, height);
            setImage(jumping[i]);
            Greenfoot.delay(2);
            if(i < 6)this.setLocation(getX(), getY() - (i * 15));
            else{
                while(this.getY() < h)
                {
                    this.setLocation(getX(), getY() + fakeGrav);
                    fakeGrav++;
                    Greenfoot.delay(1);
                }
            }
            
        }
        
        setImage(idle);
    }
    
    public void run(GreenfootImage f1, GreenfootImage f2)
    {
        setImage(f1);
        Greenfoot.delay(4);
        setImage(f2);
        Greenfoot.delay(4);
    }
}
