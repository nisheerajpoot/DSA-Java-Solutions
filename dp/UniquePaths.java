package dp;

public class UniquePaths {

    /*
     * ============================================================
     * Problem   : Unique Paths
     * Platform  : LeetCode 62
     * Pattern   : 2D DP / Grid DP
     *
     * Approach:
     * We have an m x n grid.
     *
     * From each cell, we can come from:
     *
     * 1. Top      -> dp[i - 1][j]
     * 2. Left     -> dp[i][j - 1]
     *
     * Therefore:
     *
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     *
     * First row:
     * Every cell has only one way to reach it.
     *
     * First column:
     * Every cell has only one way to reach it.
     *
     * Time Complexity  : O(m * n)
     * Space Complexity : O(m * n)
     * ============================================================
     */

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // First row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // First column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Fill remaining cells
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                dp[i][j] =
                        dp[i - 1][j]
                        + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        UniquePaths obj = new UniquePaths();

        int m = 3;
        int n = 7;

        int result = obj.uniquePaths(m, n);

        System.out.println("Unique Paths: " + result);
    }
}