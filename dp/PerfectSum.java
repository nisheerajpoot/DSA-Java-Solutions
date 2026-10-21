package dp;

/*
 * Platform: GeeksforGeeks
 * Problem: Perfect Sum Problem
 * Pattern: 0/1 Knapsack / Subset Sum DP
 *
 * Approach:
 * 1. Create a 2D DP array.
 * 2. dp[i][sum] stores the number of subsets
 *    using the first i elements with the given sum.
 * 3. Count subsets by excluding or including
 *    the current element.
 * 4. Return dp[n][target].
 *
 * Time Complexity: O(n * target)
 * Space Complexity: O(n * target)
 */

public class PerfectSum {

    public int perfectSum(int[] arr, int target) {

        int n = arr.length;
        int mod = 1000000007;

        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= target; sum++) {

                // Exclude the current element
                dp[i][sum] = dp[i - 1][sum];

                // Include the current element
                if (arr[i - 1] <= sum) {
                    dp[i][sum] = (int) (
                        (dp[i][sum]
                        + dp[i - 1][sum - arr[i - 1]]) % mod
                    );
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 6, 8, 10};
        int target = 10;

        PerfectSum obj = new PerfectSum();

        int result = obj.perfectSum(arr, target);

        System.out.println("Number of Subsets: " + result);
    }
}
