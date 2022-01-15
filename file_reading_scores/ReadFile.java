import java.util.Scanner; // Used for file reading
import java.util.ArrayList; 
import java.io.*; // Used for file reading

/**
 * Class used for score extracting
 * 
 * @author Carl
 * @version 2021.11.06
 */
public class ReadFile  
{
    /**
     * @author Carl
     * 
     * Method accesses Words.txt and stores all entries into an 
     * ArrayList called wordList 
     */
    public static ArrayList<String> extractScores()
    {
        ArrayList<String> output = new ArrayList<String>();
        try
        {
            File file = new File("Scores.txt"); // File that contains words
            Scanner scanner = new Scanner(file); // To extract words
            
            while (scanner.hasNextLine())
            {
                output.add(scanner.nextLine().toLowerCase()); // .txt -> ArrayList
            }
            
            scanner.close(); // Destroy scanner
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Something went wrong while trying to read Scores.txt.");
        }
        return output;
    }
}