package dp;

import java.util.Arrays;

/*
 * Platform: LeetCode
 * Problem: Perfect Squares
 * Problem Number: 279
 * Pattern: 1D DP / Unbounded Knapsack
 *
 * Approach:
 * 1. dp[i] stores the minimum number of perfect squares
 *    required to make the sum i.
 * 2. Initialize all dp values with Integer.MAX_VALUE.
 * 3. Set dp[0] = 0.
 * 4. Generate perfect squares and update dp values.
 * 5. Return dp[n].
 *
 * Time Complexity: O(n * sqrt(n))
 * Space Complexity: O(n)
 */

public class PerfectSquares {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;

            for (int j = square; j <= n; j++) {
                if (dp[j - square] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(
                        dp[j],
                        dp[j - square] + 1
                    );
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 12;

        PerfectSquares obj = new PerfectSquares();

        int result = obj.numSquares(n);

        System.out.println("Minimum Number of Perfect Squares: " + result);
    }
}