import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author Jayden, Carl
 * @version 2022.01.26
 */
public class Button extends Actor
{ 
    GreenfootImage buttonIdle = new GreenfootImage("playbutton2.png");
    private int delay;
    private int transparency;
    private boolean increase = false;
    private SimpleTimer timer = new SimpleTimer();

    public Button()
    {
        setImage(buttonIdle);
        timer.mark();
    }
    
    public void act()
    {
        animateButton();
        
        if(Greenfoot.mouseClicked(this))
        {
            setImage(new GreenfootImage("playbutton3.png"));
            Greenfoot.setWorld(new InstructionsScreen());
            SoundEffects.playTheme();
        }
        
        setImage(buttonIdle);
    }
    
    // Animate the button when idling
    private void animateButton()
    {
        if (timer.millisElapsed() > 20) {
            if (increase) {
                if (transparency > 245) increase = false;
                else transparency+=10;
            } else {
                if (transparency < 15) increase = true;
                else transparency-=10;
            }
            timer.mark();
        }
        getImage().setTransparency(transparency);
    }
}
