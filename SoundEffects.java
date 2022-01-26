import greenfoot.*;

/**
 * Class handes sound effects
 * 
 * @author Yoyo and Carl
 * @version 2022.01.20
 * 
 * NOTE: Due to how some of the files were downloaded, Greenfoot will throw a warning/error because
 * of these files. We are certain that the game works fine still and that the sound effects still work
 * 
 * Edit: The files were re-processed with ffmpeg, but Greenfoot still might throw a random error with these
 * files for some reason.
 */
public class SoundEffects
{
    static GreenfootSound theme = new GreenfootSound("finalDestination.mp3"); // Main theme

    // Method plays sound effect x, at volume y
    private static void playSound(GreenfootSound x, int y) {
        x.setVolume(y);
        x.play();
    }

    // Menu music before game loads
    public static void menuSound(){
        playSound(new GreenfootSound("menuSound.mp3"), 30);
    }
    
    // Countdown ticker sound 
    public static void countdownSound(){
        playSound(new GreenfootSound("countdown.mp3"), 30);
    }
    
    // Start sound
    public static void startSound(){
        playSound(new GreenfootSound("start.mp3"), 30);
    }
    
    // Ranged character attack auto sound
    public static void shootAutoSound(){
        playSound(new GreenfootSound("shootAutoSound.mp3"), 40);
    }
    
    // Ranged character attack special sound
    public static void shootSpecialSound(){
        playSound(new GreenfootSound("shootSpecialSound.mp3"), 30);
    }
    
    // Melee character attack auto sound
    public static void dashAutoSound(){
        playSound(new GreenfootSound("dashAutoSound.mp3"), 30);
    }
    
    // Melee character attack special sound
    public static void dashSpecialSound(){
        playSound(new GreenfootSound("dashSpecialSound.mp3"), 30);
    }
    
    // Sound when character is hit by special ability
    public static void hitBySpecialSound(){
        playSound(new GreenfootSound("hitBySpecialSound.mp3"), 30);
    }
    
    // Sound when character is hit by bullet
    public static void hitByBulletSound(){
        playSound(new GreenfootSound("hitByBulletSound.mp3"), 40);
    }
    
    // Sound when character is his by dash
    public static void hitByDashSound(){
        playSound(new GreenfootSound("hitByDashSound.mp3"), 40);
    }
    
    // Death sound when a character dies
    public static void deathSound(){
        playSound(new GreenfootSound("deathSound.mp3"), 50);
    }
    
    // Respawn sound when a character respawns
    public static void respawnSound(){
        playSound(new GreenfootSound("respawnSound.mp3"), 50);
    }
    
    // Victory sound when a player wins
    public static void victorySound(){
        playSound(new GreenfootSound("victorySound.mp3"), 50);
    }

    // Announcer: Player 1 wins
    public static void player1Sound(){
        playSound(new GreenfootSound("player1Wins.mp3"), 30);
    }

    // Announcer: Player 2 wins
    public static void player2Sound(){
        playSound(new GreenfootSound("player2Wins.mp3"), 30);
    }

    // Announcer: Player 3 wins
    public static void tieSound(){
        playSound(new GreenfootSound("noContest.mp3"), 30);
    }

    // When players jump 
    public static void jumpSound() {
        playSound(new GreenfootSound("jump.mp3"), 30);
    }

    // Plays the theme song until the scores screen appears
    public static void playTheme() {
        if (theme.isPlaying()) {
            theme.stop();
            theme.setVolume(25);
            theme.playLoop();
        }
        else {
            theme.setVolume(25);
            theme.playLoop();
        }
    }

    // Stop theme music
    public static void stopTheme() {
        theme.stop();
    }
}
