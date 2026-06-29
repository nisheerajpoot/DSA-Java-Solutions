package recursion;


import java.util.Scanner;

public class SubsequenceWithSumK {

    /*
      Platform : GeeksforGeeks

      Question : Subsequence with Sum K

      Pattern  : Recursion + Backtracking + Memoization

      Approach :
      Include / Exclude

      Idea :
      - For every element, there are
        two choices:
          1. Include the current element
             in the subsequence.
          2. Exclude the current element.
      - If the remaining required sum
        becomes 0, a valid subsequence
        is found.
      - If all elements are processed
        and the sum is still not 0,
        return false.
      - Use Memoization (DP) to avoid
        solving the same state multiple times.

      Time Complexity :
      O(n × k)

      Space Complexity :
      O(n × k)

      (DP Table + Recursive Call Stack)
    */

    Boolean[][] dp;

    public boolean checkSubsequenceSum(int[] arr, int k) {

        dp = new Boolean[arr.length + 1][k + 1];

        return solve(arr, 0, k);
    }

    private boolean solve(int[] arr, int index, int k) {

        // Base Case : Required sum found
        if (k == 0) {
            return true;
        }

        // Base Case : No elements left
        if (index == arr.length) {
            return false;
        }

        // Memoization
        if (dp[index][k] != null) {
            return dp[index][k];
        }

        // Include Current Element
        boolean take = false;

        if (arr[index] <= k) {
            take = solve(arr, index + 1, k - arr[index]);
        }

        // Exclude Current Element
        boolean notTake = solve(arr, index + 1, k);

        // Store and Return
        return dp[index][k] = take || notTake;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        SubsequenceWithSumK obj = new SubsequenceWithSumK();

        System.out.println(obj.checkSubsequenceSum(arr, k));

        sc.close();
    }
}
