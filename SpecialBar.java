import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpecialBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialBar extends Actor
{
    private int originalWidth = 0;
    private int width = 0;
    private int adjust = 50;
    
    private String player;
    
    public SpecialBar(String player){
        this.player = player;
        getImage().scale(50, 20);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
        // Getter and setter
    public int getWidth(){
        return width;
    }
    
    // Change length of special bar as attacks are successful
    public void setWidth(int newWidth){
        if(newWidth == 0){
            width = 1;
            getImage().scale(1, 20);
            if(player.equals("one")){
                setLocation(20, 20);
            } else {
                setLocation(1260, 20);
            }
        }
        if(newWidth <= 9){
            width = newWidth;
            getImage().scale(50 * (newWidth-1), 20);
            if(player.equals("one")){
                setLocation(getX() + 25 * newWidth, getY());
            } else {
                setLocation(1225 - 25 * (newWidth - 2), getY());
            }             
        }
        if(newWidth == 8){
            if(player.equals("one")){
                MyWorld.player1.setCanUseSpecial(true);
            } else {
                MyWorld.player2.setCanUseSpecial(true);
            }
        }
    }
}
