import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background1 extends Actor
{
    /**
     * Act - do whatever the Background1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
    public ba */
    
    int percentScale = 13;
    int width = getImage().getWidth()*percentScale/100;
    int height = getImage().getHeight()*percentScale/100;
    
    public Background1(){
        getImage().scale(width, height);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
