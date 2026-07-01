package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubsetSums {

    /*
      Platform : GeeksforGeeks

      Question : Subset Sums

      Pattern  : Recursion + Backtracking

      Approach :
      Include / Exclude

      Idea :
      - For every element, there are
        two choices:
          1. Include the current element
             in the subset sum.
          2. Exclude the current element.
      - When all elements have been
        processed, store the current sum.
      - Finally, sort all subset sums.

      Time Complexity :
      O(n × 2^n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)

      Note :
      If output space is considered,
      the total space complexity becomes
      O(2^n).
    */

    public ArrayList<Integer> subsetSums(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        solve(arr, 0, 0, ans);

        Collections.sort(ans);

        return ans;
    }

    private void solve(int[] arr,
                       int index,
                       int sum,
                       ArrayList<Integer> ans) {

        // Base Case
        if (index == arr.length) {
            ans.add(sum);
            return;
        }

        // Include Current Element
        solve(arr, index + 1, sum + arr[index], ans);

        // Exclude Current Element
        solve(arr, index + 1, sum, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SubsetSums obj = new SubsetSums();

        ArrayList<Integer> ans = obj.subsetSums(arr);

        System.out.println(ans);

        sc.close();
    }
}