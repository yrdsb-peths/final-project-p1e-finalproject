import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Actor for top platform that can be ducked
 * 
 * @author Yoyo
 * @version 2022.01.26
 */
public class TopBackground extends Background
{
    GreenfootImage topB = new GreenfootImage("TopPlatform.png");
    
    public TopBackground() {
        setImage(topB);
        getImage().scale(670, 50);
    }
}
