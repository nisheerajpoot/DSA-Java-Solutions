package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class ReplaceElementsWithGreatestElementOnRightSide {

    /*
      Platform : LeetCode

      Question : Replace Elements with Greatest Element on Right Side

      Pattern  : Recursion

      Approach :
      Reverse Recursive Traversal

      Idea :
      - Traverse the array recursively
        until the last element.
      - Replace the last element with -1.
      - While returning from recursion,
        keep track of the maximum element
        seen on the right.
      - Replace the current element with
        the maximum value on its right.
      - Return the maximum between the
        current element and the right-side
        maximum for the previous calls.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public int[] replaceElements(int[] arr) {

        solve(arr, 0);

        return arr;
    }

    private int solve(int[] arr, int index) {

        // Base Case
        if (index == arr.length - 1) {

            int last = arr[index];

            arr[index] = -1;

            return last;
        }

        // Get Maximum Element on Right Side
        int rightMax = solve(arr, index + 1);

        int current = arr[index];

        // Replace Current Element
        arr[index] = rightMax;

        // Return Maximum for Previous Calls
        return Math.max(current, rightMax);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ReplaceElementsWithGreatestElementOnRightSide obj =
                new ReplaceElementsWithGreatestElementOnRightSide();

        System.out.println(Arrays.toString(obj.replaceElements(arr)));

        sc.close();
    }
}