package dp;

import java.util.*;

public class Triangle {

    /*
     * Platform: LeetCode
     * Problem: Triangle
     * Problem Number: 120
     * Pattern: 2D Dynamic Programming
     *
     * Approach:
     * 1. Initialize the last row of the DP table.
     * 2. Traverse from the second-last row to the first row.
     * 3. Choose the minimum path from the two children.
     * 4. Return dp[0][0].
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {

                dp[i][j] = triangle.get(i).get(j)
                        + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        Triangle obj = new Triangle();

        int result = obj.minimumTotal(triangle);

        System.out.println("Minimum Path Sum: " + result);
    }
}