package dp;

public class MinCostClimbingStairs {

    /*
     * ============================================================
     * Problem   : Min Cost Climbing Stairs
     * Platform  : LeetCode 746
     * Pattern   : 1D DP - Tabulation
     *
     * Approach:
     * dp[i] = minimum cost required to reach stair i.
     *
     * To reach stair i, we can come from:
     *
     * 1. i - 1
     * 2. i - 2
     *
     * Therefore:
     *
     * dp[i] = cost[i] + min(dp[i - 1], dp[i - 2])
     *
     * Base Cases:
     * dp[0] = cost[0]
     * dp[1] = cost[1]
     *
     * We can start from either stair 0 or stair 1.
     * Therefore, the final answer is:
     *
     * min(dp[n - 1], dp[n - 2])
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     * ============================================================
     */

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {

            dp[i] = cost[i]
                    + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {

        MinCostClimbingStairs obj =
                new MinCostClimbingStairs();

        int[] cost = {10, 15, 20};

        int result = obj.minCostClimbingStairs(cost);

        System.out.println("Minimum Cost: " + result);
    }
}