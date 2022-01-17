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
    
    public void player1movement(GreenfootImage[] p1jump, GreenfootImage p1idle)
    {
        if(Greenfoot.isKeyDown("w") && inAir == false)
        {
            jump(p1jump, p1idle,1);
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
    
    public void player2movement(GreenfootImage[] p2jump, GreenfootImage p2idle)
    {
        if(Greenfoot.isKeyDown("up") && inAir == false)
        {
            jump(p2jump,p2idle,2);
            inAir = false;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            this.setLocation(getX() - moveSpeed, getY());
        }
        if(Greenfoot.isKeyDown("down"))
        {
            
        }
        if(Greenfoot.isKeyDown("right"))
        {
            this.setLocation(getX() + moveSpeed, getY());
        }
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
}
