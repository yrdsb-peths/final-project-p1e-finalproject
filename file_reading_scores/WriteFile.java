import java.io.*; // Used for file reading

/**
 * Class used for score writing
 * 
 * @author Carl
 * @version 2022.01.15
 */
public class WriteFile  
{
    /**
     * @author Carl
     * 
     * Method accesses Words.txt and stores all entries into an 
     * ArrayList called wordList 
     */
    public static void writeScore(String score)
    {
        try
        {
            FileWriter fw = new FileWriter("Scores.txt", true);
            fw.write(score + "\n");//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
}