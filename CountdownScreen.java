import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Play a countdown before the game starts
 * 
 * @author Yoyo, Carl
 * @version 2022.01.25
 */
public class CountdownScreen extends World
{
    // Countdown Variables
    Label count;
    boolean acted = false;

    /**
     * Constructor for objects of class CountdownScreen.
     * 
     */
    
    GreenfootImage background = new GreenfootImage("CountdownBackground.jpg");
    
    public CountdownScreen()
    {    
        super(1280, 720, 1); 
        background.scale(1280, 720);
        setBackground(background);
        
        count = new Label(3, 200);
        addObject(count, getWidth()/2, getHeight()/2);
    }
    
    // Run countdown once
    public void act(){
        if(!acted){
            acted = true;
            countdown();
        }
    }
    
    // Display a 3, 2, 1, Start! countdown, plays music too.
    private void countdown(){
        SoundEffects.countdownSound();
        for(int i = 3; i > 0; i--){
            count.setValue(i);
            Greenfoot.delay(60);
        }
        count.setValue("START!");
        SoundEffects.startSound();
        Greenfoot.delay(30);
        Greenfoot.setWorld(new MyWorld());
    }
}
