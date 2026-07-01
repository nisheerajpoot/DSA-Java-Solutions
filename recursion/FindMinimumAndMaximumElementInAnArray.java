package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class FindMinimumAndMaximumElementInAnArray {

    /*
      Platform : GeeksforGeeks

      Question : Find Minimum and Maximum Element in an Array

      Pattern  : Recursion

      Approach :
      Recursive Traversal

      Idea :
      - Initialize both minimum and maximum
        with the first element.
      - Traverse the array recursively.
      - For every element:
          • Update the minimum if the current
            element is smaller.
          • Update the maximum if the current
            element is larger.
      - After visiting all elements,
        return the minimum and maximum.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    int min;
    int max;

    public ArrayList<Integer> getMinMax(int[] arr) {

        min = arr[0];
        max = arr[0];

        solve(arr, 0);

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(min);
        ans.add(max);

        return ans;
    }

    private void solve(int[] arr, int index) {

        // Base Case
        if (index == arr.length) {
            return;
        }

        // Update Minimum
        if (arr[index] < min) {
            min = arr[index];
        }

        // Update Maximum
        if (arr[index] > max) {
            max = arr[index];
        }

        // Recursive Call
        solve(arr, index + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        FindMinimumAndMaximumElementInAnArray obj =
                new FindMinimumAndMaximumElementInAnArray();

        System.out.println(obj.getMinMax(arr));

        sc.close();
    }
}