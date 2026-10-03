package dp;

public class HouseRobber {

    /*
     * ============================================================
     * Problem   : House Robber
     * Platform  : LeetCode 198
     * Pattern   : 1D DP - Tabulation
     *
     * Approach:
     * We cannot rob two adjacent houses.
     *
     * For every house i, we have two choices:
     *
     * 1. Skip current house
     *    dp[i - 1]
     *
     * 2. Rob current house
     *    dp[i - 2] + nums[i]
     *
     * Therefore:
     *
     * dp[i] = Math.max(
     *              dp[i - 1],
     *              dp[i - 2] + nums[i]
     *          )
     *
     * Base Cases:
     * dp[0] = nums[0]
     * dp[1] = max(nums[0], nums[1])
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     * ============================================================
     */

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];

        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            dp[i] = Math.max(
                    dp[i - 1],
                    dp[i - 2] + nums[i]
            );
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        HouseRobber obj = new HouseRobber();

        int[] nums = {2, 7, 9, 3, 1};

        int result = obj.rob(nums);

        System.out.println("Maximum Money: " + result);
    }
}