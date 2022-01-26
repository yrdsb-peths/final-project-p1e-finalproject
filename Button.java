import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button that starts the game
 * 
 * @author Jayden, Carl
 * @version 2022.01.26
 */
public class Button extends Actor
{ 
    // Default variables
    GreenfootImage buttonIdle = new GreenfootImage("playbutton2.png");
    private int delay;
    private int transparency;
    private boolean increase = false;
    private SimpleTimer timer = new SimpleTimer();

    // Button constructor
    public Button()
    {
        setImage(buttonIdle);
        timer.mark();
    }
    
    // Act method that loops
    public void act()
    {
        animateButton();
        
        // Go to insturctions screen if button is clicked
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
