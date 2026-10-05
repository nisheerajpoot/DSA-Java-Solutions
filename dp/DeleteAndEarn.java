package dp;

public class DeleteAndEarn {

    /*
     * ============================================================
     * Problem   : Delete and Earn
     * Platform  : LeetCode 740
     * Pattern   : 1D DP / House Robber Pattern
     *
     * Approach:
     * First, calculate total points for every number.
     *
     * points[i] = i * frequency of i
     *
     * If we take number i, then we cannot take:
     *
     *      i - 1
     *      i + 1
     *
     * This becomes exactly like the House Robber problem.
     *
     * Therefore:
     *
     * dp[i] = max(
     *              dp[i - 1],
     *              dp[i - 2] + points[i]
     *          )
     *
     * dp[i - 1] -> Don't take i
     * dp[i - 2] + points[i] -> Take i
     *
     * Time Complexity  : O(n + maxValue)
     * Space Complexity : O(maxValue)
     * ============================================================
     */

    public int deleteAndEarn(int[] nums) {

        // Find maximum number
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Store total points for each number
        int[] points = new int[max + 1];

        for (int num : nums) {
            points[num] += num;
        }

        // DP array
        int[] dp = new int[max + 1];

        dp[0] = 0;

        if (max >= 1) {
            dp[1] = points[1];
        }

        // House Robber style DP
        for (int i = 2; i <= max; i++) {

            dp[i] = Math.max(
                    dp[i - 1],
                    dp[i - 2] + points[i]
            );
        }

        return dp[max];
    }

    public static void main(String[] args) {

        DeleteAndEarn obj = new DeleteAndEarn();

        int[] nums = {3, 4, 2};

        int result = obj.deleteAndEarn(nums);

        System.out.println("Maximum Points: " + result);
    }
}