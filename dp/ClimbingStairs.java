package dp;

public class ClimbingStairs {

    /*
     * ============================================================
     * Problem   : Climbing Stairs
     * Platform  : LeetCode 70
     * Pattern   : 1D DP - Tabulation
     *
     * Approach:
     * Har stair par pahunchne ke 2 possible ways hain:
     *
     * 1. Previous stair se 1 step
     * 2. Two stairs before se 2 steps
     *
     * Therefore:
     *
     * dp[i] = dp[i - 1] + dp[i - 2]
     *
     * Base Cases:
     * dp[1] = 1
     * dp[2] = 2
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     * ============================================================
     */

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        ClimbingStairs obj = new ClimbingStairs();

        int n = 5;

        int result = obj.climbStairs(n);

        System.out.println("Number of ways: " + result);
    }
}