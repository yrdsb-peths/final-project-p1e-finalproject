import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*; 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

/**
 * Write a description of class ScoreUtilities here.
 * 
 * @author Carl
 * @version 2022.01.18
 */
public class ScoreUtilities {

    /**
     * Converts an ArrayList<String> with a delimiter into String[][]
     * 
     * @param inputs ArrayList<String> with a delimiter in each index
     * @return String[][], formated according to demiliter: Score -> Date
     */
    public static String[][] convertArray(ArrayList<String> inputs) {
        String[][] output = new String[inputs.size()][2];
        for (int i = 0; i < inputs.size(); i++) {
            output[i][0] = getScore(inputs.get(i));
            output[i][1] = getDate(inputs.get(i));
        }
        return output;
    }

    /**
     * Method takes an string containing a deliminiter, returns the date
     * 
     * @param input String with demiliter 
     * @return Substring'd from input
     */
    public static String getDate(String input) {
        int delimiter = input.indexOf('-');
        return input.substring(0, delimiter);
    }

    /**
     * Method takes an string containing a deliminiter, returns the score
     * 
     * @param input String with demiliter 
     * @return Substring'd from input
     */
    public static String getScore(String input) {
        int delimiter = input.indexOf('-');
        return input.substring(delimiter + 1, input.length());
    }

    /**
     * Reverses an array
     * 
     * @param arr String[][] array
     */
    public static void reverse(String[][] arr) {
        Collections.reverse(Arrays.asList(arr));
    }

    /**
     * Debugging purposes; not used in main code
     * Prints out 2D array
     * 
     * @param array A 2D array
     */
    public static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(array[i][j]);
            }
        }
    }

    /**
     * Method accesses Words.txt and stores all entries into an ArrayList<String>
     * 
     * @return ArrayList<String> 
     */
    public static ArrayList<String> extractScores() {
        ArrayList<String> output = new ArrayList<String>();
        try {
            File file = new File("Scores.txt"); // File that contains words
            Scanner scanner = new Scanner(file); // To extract words

            while (scanner.hasNextLine()) {
                output.add(scanner.nextLine().toLowerCase()); // .txt -> ArrayList
            }

            scanner.close(); // Destroy scanner
        } 
        catch (FileNotFoundException e) {
            System.out.println("Something went wrong while trying to read Scores.txt.");
        }
        return output;
    }

    /**
     * Method writes score to Scores.txt
     * 
     * @param score String containing delimiter (-)
     */
    public static void writeScore(String x) {
        try {
            String a = getDate();
            String score = a + "-" + x;
            FileWriter fw = new FileWriter("Scores.txt", true);
            fw.write(score + "\n"); // Appends the string to the file
            fw.close();
        } 
        catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    private static String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /**
     * Quicksort method that gets called
     * 
     * @param arr String[][]
     */
    public static void quickSort(String[][] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    /**
     * QuickSort method that does work in the background
     * 
     * @param arr String[][]
     * @param low Pointer
     * @param high Pointer
     */
    private static void quickSort(String[][] arr, int low, int high) {
        if (high <= low) return; // Pointers cross

        // Get partition element
        // Move all values in array to left or right of partitioning element
        int j = partition(arr, low, high); 

        quickSort(arr, low, j-1); // Sort left side of partitioning element
        quickSort(arr, j+1, high); // Sort right side of partitioning element
    }

    /**
     * QuickSort helper method
     * 
     * @param arr String[][]
     * @param low Pointer
     * @param high Pointer
     * @return Partion element
     */
    private static int partition(String[][] arr, int low, int high) {
        // High and low pointers that move starting at array
        // start or end, gradually moving closer to each other
        int i = low;
        int j = high + 1;

        while (true) {
            while (Integer.parseInt(arr[++i][0]) < Integer.parseInt(arr[low][0])) {
                // Find an item left of partition element to swap
                if (i == high) break;
            }
            while (Integer.parseInt(arr[--j][0]) > Integer.parseInt(arr[low][0])) {
                // Find an item on the right of partition element to swap
                if (j == low) break;
            }
            if (i >= j) break; // High and low pointers cross each other
            swap(arr, i, j);
        }
        swap(arr, low, j); // Swap partitioning element to be sorted
        return j; // "Index of item now know to be in sorted place"
    }
    
    /**
     * Sorting helper method - does the swapping
     * 
     * @param arr Array to be swaped, String[][]
     * @param a Element to be swapped
     * @param b Element to be swapped
     */
    private static void swap(String[][] arr, int a, int b) {
        String temp = arr[a][0];
        arr[a][0] = arr[b][0];
        arr[b][0] = temp;

        String temp2 = arr[a][1];
        arr[a][1] = arr[b][1];
        arr[b][1] = temp2;
    }
}
