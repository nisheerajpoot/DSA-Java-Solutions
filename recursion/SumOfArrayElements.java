package recursion;

import java.util.Scanner;

public class SumOfArrayElements {

    /*
      Platform : GeeksforGeeks

      Question : Sum of Array Elements

      Pattern  : Recursion

      Approach :
      Recursive Array Traversal

      Idea :
      - Start traversing from index 0.
      - If the index reaches the end of the array,
        return 0.
      - Otherwise, add the current element to the
        sum of the remaining elements recursively.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public int arraySum(int[] arr) {
        return sum(arr, 0);
    }

    private int sum(int[] arr, int index) {

        // Base Case
        if (index == arr.length) {
            return 0;
        }

        // Recursive Relation
        return arr[index] + sum(arr, index + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SumOfArrayElements obj = new SumOfArrayElements();

        System.out.println(obj.arraySum(arr));

        sc.close();
    }
}