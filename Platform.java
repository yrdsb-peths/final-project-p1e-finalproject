import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent class for all platforms - What characters stand on
 * 
 * @author Carl
 * @version 2022.01.20
 */
public class Platform extends Actor
{
    // All platforms to be set transparent and overlayed on a world
    public void setTransparent(Platform actor) {
        actor.getImage().setTransparency(0);
    }
}
