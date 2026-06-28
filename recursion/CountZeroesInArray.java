package recursion;

import java.util.Scanner;

public class CountZeroesInArray {

    /*
      Platform : GeeksforGeeks

      Question : Count Zeroes in an Array

      Pattern  : Recursion

      Approach :
      Recursive Array Traversal

      Idea :
      - Start traversing the array from index 0.
      - If the index reaches the end of the array,
        return 0.
      - If the current element is 0,
        count it and recursively process
        the remaining array.
      - Otherwise, skip the current element
        and continue recursively.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public int countZeroes(int[] arr) {
        return count(arr, 0);
    }

    private int count(int[] arr, int index) {

        // Base Case
        if (index == arr.length) {
            return 0;
        }

        // Current element is zero
        if (arr[index] == 0) {
            return 1 + count(arr, index + 1);
        }

        // Recursive Relation
        return count(arr, index + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        CountZeroesInArray obj = new CountZeroesInArray();

        System.out.println(obj.countZeroes(arr));

        sc.close();
    }
}