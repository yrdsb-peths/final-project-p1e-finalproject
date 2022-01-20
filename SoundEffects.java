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
        GreenfootSound sfxShootAuto = new GreenfootSound("shootAutoSound.mp3");
        sfxShootAuto.setVolume(40);
        sfxShootAuto.play();
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
    
    // Sound when character is hit by special ability
    public static void hitBySpecialSound(){
        GreenfootSound sfxHitBySpecial = new GreenfootSound("hitBySpecialSound.mp3");
        sfxHitBySpecial.setVolume(30);
        sfxHitBySpecial.play();
    }
    
    // Sound when character is hit by bullet
    public static void hitByBulletSound(){
        GreenfootSound sfxHitByBullet = new GreenfootSound("hitByBulletSound.mp3");
        sfxHitByBullet.setVolume(40);
        sfxHitByBullet.play();
    }
    
    // Sound when character is his by dash
    public static void hitByDashSound(){
        GreenfootSound sfxHitByDash = new GreenfootSound("hitByDashSound.mp3");
        sfxHitByDash.setVolume(40);
        sfxHitByDash.play();
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
