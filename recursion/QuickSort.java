package recursion;


import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    /*
      Platform : GeeksforGeeks

      Question : Quick Sort

      Pattern  : Divide and Conquer(recursion)

      Approach :
      Partitioning

      Idea :
      - Choose the last element as the pivot.
      - Partition the array so that:
          • Elements smaller than or equal
            to the pivot are placed on the left.
          • Elements greater than the pivot
            are placed on the right.
      - The pivot reaches its correct position.
      - Recursively sort the left and
        right subarrays.

      Time Complexity :

      Best Case    : O(n log n)

      Average Case : O(n log n)

      Worst Case   : O(n²)

      (Occurs when the pivot is always
      the smallest or largest element.)

      Space Complexity :

      Best/Average : O(log n)

      Worst Case   : O(n)

      (Recursive Call Stack)
    */

    public void quickSort(int[] arr, int low, int high) {

        // Base Case
        if (low >= high) {
            return;
        }

        // Partition Array
        int pivotIndex = partition(arr, low, high);

        // Sort Left Part
        quickSort(arr, low, pivotIndex - 1);

        // Sort Right Part
        quickSort(arr, pivotIndex + 1, high);
    }

    private int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {

                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place Pivot at Correct Position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        QuickSort obj = new QuickSort();

        obj.quickSort(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}