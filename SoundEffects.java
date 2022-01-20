import greenfoot.*;
/**
 * Class handes sound effects
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundEffects  
{
    // Menu music before game loads
    public static void menuSound(){
        GreenfootSound sfxMenuSound = new GreenfootSound("menySound.mp3");
        sfxMenuSound.setVolume(30);
        sfxMenuSound.play();
    }
    
    // Ranged character attack auto sound
    public static void shootAutoSound(){
        GreenfootSound sfxShootAuto = new GreenfootSound("shootAutoSound.mp3");
        sfxShootAuto.setVolume(25);
        sfxShootAuto.play();
    }
    
    // Ranged character attack special sound
    public static void shootSpecialSound(){
        GreenfootSound sfxShootSpecial = new GreenfootSound("shootSpecialSound.mp3");
        sfxShootSpecial.setVolume(30);
        sfxShootSpecial.play();
    }
    
    // Melee character attack auto sound
    public static void dashAutoSound(){
        
    }
    
    // Melee character attack special sound
    public static void dashSpecialSound(){
        GreenfootSound sfxDashSpecial = new GreenfootSound("dashSpecialSound.mp3");
        sfxDashSpecial.setVolume(30);
        sfxDashSpecial.play();
    }
    
    // Death sound when a character dies
    public static void deathSound(){
        GreenfootSound sfxDeathSound = new GreenfootSound("deathSound.mp3");
        sfxDeathSound.setVolume(30);
        sfxDeathSound.play();
    }
    
    // Victory sound when a player wins
    public static void victorySound(){
        GreenfootSound sfxVictorySound = new GreenfootSound("victorySound.mp3");
        sfxVictorySound.setVolume(50);
        sfxVictorySound.play();
    }
}
