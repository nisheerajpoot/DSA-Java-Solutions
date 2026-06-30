package recursion;


import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    /*
      Platform : GeeksforGeeks

      Question : Merge Sort

      Pattern  : Divide and Conquer(recursion)

      Approach :
      Divide, Sort and Merge

      Idea :
      - Divide the array into two halves.
      - Recursively sort the left half.
      - Recursively sort the right half.
      - Merge the two sorted halves into
        a single sorted array.

      Time Complexity :
      O(n log n)

      Space Complexity :
      O(n)

      (Temporary Arrays Used During Merge)
    */

    public void mergeSort(int[] arr, int left, int right) {

        // Base Case
        if (left >= right) {
            return;
        }

        // Find Middle
        int mid = left + (right - left) / 2;

        // Sort Left Half
        mergeSort(arr, left, mid);

        // Sort Right Half
        mergeSort(arr, mid + 1, right);

        // Merge Both Halves
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy Left Half
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        // Copy Right Half
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Merge Two Sorted Arrays
        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // Copy Remaining Left Elements
        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        // Copy Remaining Right Elements
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        MergeSort obj = new MergeSort();

        obj.mergeSort(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}