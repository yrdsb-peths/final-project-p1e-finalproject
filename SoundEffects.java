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
        playSound(new GreenfootSound("menySound.mp3"), 30);
    }
    
    // Ranged character attack auto sound
    public static void shootAutoSound(){
        playSound(new GreenfootSound("shootAutoSound.mp3"), 25);
    }
    
    // Ranged character attack special sound
    public static void shootSpecialSound(){
        playSound(new GreenfootSound("shootSpecialSound.mp3"), 30);
    }
    
    // Melee character attack auto sound
    public static void dashAutoSound(){
        
    }
    
    // Melee character attack special sound
    public static void dashSpecialSound(){
        playSound(new GreenfootSound("dashSpecialSound.mp3"), 30);
    }
    
    // Death sound when a character dies
    public static void deathSound(){
        playSound(new GreenfootSound("deathSound.mp3"), 30);
    }
    
    // Victory sound when a player wins
    public static void victorySound(){
        playSound(new GreenfootSound("victorySound.mp3"), 50);
    }

    // Carl - I'm going to get these from Smash https://www.youtube.com/watch?v=3TT_9Sp-PpQ
    // Announcer: Player 1 wins
    public static void player1Sound(){

    }

    // Announcer: Player 2 wins
    public static void player2Sound(){

    }

    // Announcer: Player 3 wins
    public static void tieSound(){

    }
}
