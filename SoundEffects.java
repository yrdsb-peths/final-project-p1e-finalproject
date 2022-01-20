import greenfoot.*;
/**
 * Class handes sound effects
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundEffects  
{
    public static void shootAutoSound(){
        GreenfootSound sfxShootAuto = new GreenfootSound("shootAutoSound.mp3");
        sfxShootAuto.setVolume(25);
        sfxShootAuto.play();
    }
    
    public static void shootSpecialSound(){
        GreenfootSound sfxShootSpecial = new GreenfootSound("shootSpecialSound.mp3");
        sfxShootSpecial.setVolume(30);
        sfxShootSpecial.play();
    }
    
    public static void dashAutoSound(){
        
    }
    
    public static void dashSpecialSound(){
        GreenfootSound sfxDashSpecial = new GreenfootSound("dashSpecialSound.mp3");
        sfxDashSpecial.setVolume(30);
        sfxDashSpecial.play();
    }
}
