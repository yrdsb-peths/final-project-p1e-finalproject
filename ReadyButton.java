import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReadyButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReadyButton extends Actor
{
    /**
     * Act - do whatever the ReadyButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        checkStart();
    }
    
    private void checkStart(){
        if(Greenfoot.mousePressed(this)){
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
