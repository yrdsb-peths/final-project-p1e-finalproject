import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * StatsBar that lets users know when a Character can use their special ability
 * 
 * @author Yoyo
 * @version 2022.01.20
 */
public class SpecialBar extends StatsBar
{
    // Default variables
    private int originalWidth = 0;
    private int width = 0;
    private int adjust = 50;
    
    private String player;
    
    // SpecialBar constructor
    public SpecialBar(String player){
        this.player = player;
        getImage().scale(50, 20);
    }
    
    // Getter and setter
    public int getWidth(){
        return width;
    }
    
    // Change length of special bar as attacks are successful
    public void setWidth(int newWidth){
        // Reset to default position if bar is empty
        if(newWidth == 0){
            width = 1;
            getImage().scale(1, 20);
            if(player.equals("one")){
                setLocation(20, 20);
            } else {
                setLocation(1260, 20);
            }
        }
        
        // Update location based on new length as bar size increases
        if(newWidth <= 9){
            width = newWidth;
            getImage().scale(50 * (newWidth-1), 20);
            if(player.equals("one")){
                setLocation(20 + 25 * (newWidth - 1), getY());
            } else {
                setLocation(1225 - 25 * (newWidth - 2), getY());
            }             
        }
        
        // Let player use special if bar is full
        if(newWidth == 8){
            if(player.equals("one")){
                MyWorld.player1.setCanUseSpecial(true);
            } else {
                MyWorld.player2.setCanUseSpecial(true);
            }
        }
    }
}
