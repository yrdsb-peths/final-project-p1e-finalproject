import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        ArrayList<String> inputs = ReadFile.extractScores();
        String[][] scores = convertArray(inputs);
        QuickSort.quickSort(scores);
        reverse(scores);
        printArray(scores);
    }

    public static String[][] convertArray(ArrayList<String> inputs) {
        String[][] output = new String[inputs.size()][2];
        for (int i = 0; i < inputs.size(); i++) {
            output[i][0] = getScore(inputs.get(i));
            output[i][1] = getDate(inputs.get(i));
        }
        return output;
    }

    public static String getDate(String input) {
        int delimiter = input.indexOf('-');
        return input.substring(0, delimiter);
    }

    public static String getScore(String input) {
        int delimiter = input.indexOf('-');
        return input.substring(delimiter + 1, input.length());
    }

    public static void reverse(String[][] arr) {
        Collections.reverse(Arrays.asList(arr));
    }

    public static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}
