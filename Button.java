import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author Jayden
 * @version (a version number or a date)
 */
public class Button extends Actor
{ 
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
            Greenfoot.setWorld(new InstructionsScreen());
            SoundEffects.playTheme();
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
