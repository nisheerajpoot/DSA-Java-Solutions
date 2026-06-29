package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Reverse an Array

      Pattern  : Recursion

      Approach :
      Recursive Two-Pointer

      Idea :
      - Start with two pointers:
        one at the beginning and
        one at the end of the array.
      - If the left pointer crosses
        the right pointer, stop recursion.
      - Swap the elements at both pointers.
      - Recursively move the left pointer
        forward and the right pointer backward.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public void reverseArray(int[] arr) {
        reverse(arr, 0, arr.length - 1);
    }

    private void reverse(int[] arr, int left, int right) {

        // Base Case
        if (left >= right) {
            return;
        }

        // Swap
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        // Recursive Call
        reverse(arr, left + 1, right - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ReverseArrayUsingRecursion obj = new ReverseArrayUsingRecursion();

        obj.reverseArray(arr);

        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}