import greenfoot.*;
/**
 * Class handes sound effects
 * 
 * @author Yoyo and Carl
 * @version 2022.01.20
 */
public class SoundEffects
{
    // Method plays sound effect x, at volume y
    private static void playSound(GreenfootSound x, int y) {
        x.setVolume(y);
        x.play();
    }

    // Menu music before game loads
    public static void menuSound(){
        try {
            playSound(new GreenfootSound("menuSound.mp3"), 30);
        }
        catch (Exception e){}
    }
    
    // Ranged character attack auto sound
    public static void shootAutoSound(){
        try {
            playSound(new GreenfootSound("shootAutoSound.mp3"), 40);
        }
        catch (Exception e){}
    }
    
    // Ranged character attack special sound
    public static void shootSpecialSound(){
        try {
            playSound(new GreenfootSound("shootSpecialSound.mp3"), 30);
        }
        catch (Exception e){}
    }
    
    // Melee character attack auto sound
    public static void dashAutoSound(){
        
    }
    
    // Melee character attack special sound
    public static void dashSpecialSound(){
        try {
            playSound(new GreenfootSound("dashSpecialSound.mp3"), 30);
        }
        catch (Exception e){}
    }
    
    // Sound when character is hit by special ability
    public static void hitBySpecialSound(){
        try {
            playSound(new GreenfootSound("hitBySpecialSound.mp3"), 30);
        }
        catch (Exception e){}
    }
    
    // Sound when character is hit by bullet
    public static void hitByBulletSound(){
        try {
            playSound(new GreenfootSound("hitByBulletSound.mp3"), 40);
        }
        catch (Exception e){}
    }
    
    // Sound when character is his by dash
    public static void hitByDashSound(){
        try {
            playSound(new GreenfootSound("hitByDashSound.mp3"), 40);
        }
        catch (Exception e){}
    }
    
    // Death sound when a character dies
    public static void deathSound(){
        try {
            playSound(new GreenfootSound("deathSound.mp3"), 30);
        }
        catch (Exception e){}
    }
    
    // Victory sound when a player wins
    public static void victorySound(){
        try {
            playSound(new GreenfootSound("victorySound.mp3"), 50);
        }
        catch (Exception e){}
    }

    // Announcer: Player 1 wins
    public static void player1Sound(){
        try {
            playSound(new GreenfootSound("player1Wins.mp3"), 30);
        }
        catch (Exception e){}
    }

    // Announcer: Player 2 wins
    public static void player2Sound(){
        try {
            playSound(new GreenfootSound("player2Wins.mp3"), 30);
        }
        catch (Exception e){}
    }

    // Announcer: Player 3 wins
    public static void tieSound(){
        try {
            playSound(new GreenfootSound("noContest.mp3"), 30);
        }
        catch (Exception e){}
    }

    // When players jump 
    public static void jumpSound() {
        try {
            playSound(new GreenfootSound("jump.mp3"), 30);
        }
        catch (Exception e){}
    }
}
