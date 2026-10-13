package dp;

/*
 * Platform: GeeksforGeeks
 * Problem: 0/1 Knapsack Problem
 * Pattern: 2D Dynamic Programming
 *
 * Approach:
 * 1. Create a DP table of size (n + 1) x (W + 1).
 * 2. Initially, each item is excluded from the current solution.
 * 3. If the current item's weight is less than or equal to
 *    the available capacity, consider including it.
 * 4. Choose the maximum value between including and excluding it.
 *
 * Time Complexity: O(n * W)
 * Space Complexity: O(n * W)
 */

public class Knapsack01 {

    public int knapsack(int W, int val[], int wt[]) {

        int n = val.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                dp[i][w] = dp[i - 1][w];

                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            dp[i][w],
                            val[i - 1] + dp[i - 1][w - wt[i - 1]]
                    );
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int W = 4;
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};

        Knapsack01 obj = new Knapsack01();

        int result = obj.knapsack(W, val, wt);

        System.out.println("Maximum Value: " + result);
    }
}