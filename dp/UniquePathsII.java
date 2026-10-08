package dp;

public class UniquePathsII {

    /*
     * ============================================================
     * Problem   : Unique Paths II
     * Platform  : LeetCode 63
     * Pattern   : 2D DP / Grid DP
     *
     * Approach:
     * obstacleGrid[i][j] == 1 means obstacle.
     * obstacleGrid[i][j] == 0 means we can move through the cell.
     *
     * For every non-obstacle cell:
     *
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     *
     * because we can reach the current cell from:
     *
     * 1. Top
     * 2. Left
     *
     * If the cell contains an obstacle:
     *
     * dp[i][j] = 0
     *
     * Special Case:
     * If starting cell itself is an obstacle, answer is 0.
     *
     * Time Complexity  : O(m * n)
     * Space Complexity : O(m * n)
     * ============================================================
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // If starting cell is blocked
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Starting point
        dp[0][0] = 1;

        // First row
        for (int j = 1; j < n; j++) {

            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // First column
        for (int i = 1; i < m; i++) {

            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Fill remaining cells
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (obstacleGrid[i][j] == 0) {

                    dp[i][j] =
                            dp[i - 1][j]
                            + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        UniquePathsII obj = new UniquePathsII();

        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int result =
                obj.uniquePathsWithObstacles(obstacleGrid);

        System.out.println("Unique Paths: " + result);
    }
}