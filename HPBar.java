import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HPBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPBar extends StatsBar
{
    // Default variables 
    private int originalWidth = 400;
    private int width = 400;
    private int adjust = 50;
    
    private String player;
    
    // Assigns each bar to a player
    public HPBar(String newPlayer){
        this.player = newPlayer;
    }

    // Getter
    public int getWidth(){
        return width;
    }
    
    // Setter to change the length of green bar as HP decreases
    public void setWidth(int newWidth){
        if(newWidth == 0){
            width = originalWidth;
            getImage().scale(400, 20);
            if(player.equals("one")){
                setLocation(getX() + 3 * adjust, getY());
            } else {
                setLocation(getX() - 3 * adjust, getY());
            }
            
        } else {
            width = newWidth;
            getImage().scale(width, 20);
            if(player.equals("one")){
                setLocation(getX() - adjust, getY());
            } else {
                setLocation(getX() + adjust, getY());
            }
            
        }
    }
    
}
