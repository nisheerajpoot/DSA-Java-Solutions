package dp;

public class MinimumPathSum {

    /*
     * ============================================================
     * Problem   : Minimum Path Sum
     * Platform  : LeetCode 64
     * Pattern   : 2D DP / Grid DP - Tabulation
     *
     * Approach:
     * 1. Start from the top-left cell.
     * 2. Move only right or down.
     * 3. Store the minimum path sum in dp[i][j].
     *
     * First Cell:
     * dp[0][0] = grid[0][0]
     *
     * First Row:
     * dp[0][j] = dp[0][j-1] + grid[0][j]
     *
     * First Column:
     * dp[i][0] = dp[i-1][0] + grid[i][0]
     *
     * Remaining Cells:
     * dp[i][j] = grid[i][j]
     *            + min(dp[i-1][j], dp[i][j-1])
     *
     * Time Complexity  : O(m * n)
     * Space Complexity : O(m * n)
     * ============================================================
     */

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // First row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // First column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Remaining cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                dp[i][j] = grid[i][j] +
                    Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        MinimumPathSum obj = new MinimumPathSum();

        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        int result = obj.minPathSum(grid);

        System.out.println("Minimum Path Sum: " + result);
    }
}