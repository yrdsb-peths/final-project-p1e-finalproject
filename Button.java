import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author Jayden
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
        buttonHover();
        
        if(Greenfoot.mouseClicked(this))
        {
            setImage(new GreenfootImage("playbutton3.png"));
            Greenfoot.delay(3);
        }
        
        setImage(buttonIdle);
    }
    
    private void buttonHover()
    {

        int transparency = 255;

        for(int i = 0; i < 10; i++) {
            transparency = transparency - 20;
            getImage().setTransparency(transparency);
            Greenfoot.delay(6);
        }
        for(int i = 0; i <9; i++) {
            transparency = transparency + 20;
            getImage().setTransparency(transparency);
            Greenfoot.delay(6);
        }
    }
}
