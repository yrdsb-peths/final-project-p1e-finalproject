import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage buttonIdle = new GreenfootImage("playbutton2.png");
    public Button()
    {
        setImage(buttonIdle);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            setImage(new GreenfootImage("playbutton3.png"));
            Greenfoot.delay(3);
        }
        
        setImage(buttonIdle);
    }
}
