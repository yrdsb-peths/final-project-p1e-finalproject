import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * All backgrounds are to be scaled to fit the world
 * 
 * @author Carl
 * @version 2022.01.26
 */
public class Background extends Actor
{
    public void setScale(Background x) {
        x.getImage().scale(1000, 600);
    }
}
