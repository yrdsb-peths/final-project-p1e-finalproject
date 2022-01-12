/**
 * Write a description of class QuickSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuickSort  
{
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (high <= low) return; // Pointers cross

        // Get partition element
        // Move all values in array to left or right of partitioning element
        int j = partition(arr, low, high); 

        quickSort(arr, low, j-1); // Sort left side of partitioning element
        quickSort(arr, j+1, high); // Sort right side of partitioning element
    }

    private static int partition(int[] arr, int low, int high) {
        // High and low pointers that move starting at array
        // start or end, gradually moving closer to each other
        int i = low;
        int j = high + 1;

        while (true) {
            while (arr[++i] < arr[low]) {
                // Find an item left of partition element to swap
                if (i == high) break;
            }
            while (arr[--j] > arr[low]) {
                // Find an item on the right of partition element to swap
                if (j == low) break;
            }
            if (i >= j) break; // High and low pointers cross each other
            swap(arr, i, j);
        }
        swap(arr, low, j); // Swap partitioning element to be sorted
        return j; // "Index of item now know to be in sorted place"
    }
    
    private static void swap (int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
