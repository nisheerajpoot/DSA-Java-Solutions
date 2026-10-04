package dp;

public class HouseRobberII {

    /*
     * ============================================================
     * Problem   : House Robber II
     * Platform  : LeetCode 213
     * Pattern   : 1D DP - Circular House Robber
     *
     * Approach:
     * Houses are arranged in a circle.
     *
     * Therefore, the first and last houses are adjacent
     * and cannot both be robbed.
     *
     * We divide the problem into two cases:
     *
     * Case 1:
     * Rob from house 0 to house n - 2
     * (Exclude the last house)
     *
     * Case 2:
     * Rob from house 1 to house n - 1
     * (Exclude the first house)
     *
     * Final answer:
     *
     * max(case1, case2)
     *
     * For each range:
     *
     * dp[i] = max(
     *              dp[i - 1],
     *              dp[i - 2] + nums[start + i]
     *          )
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

        // Case 1: Exclude last house
        int case1 = robRange(nums, 0, n - 2);

        // Case 2: Exclude first house
        int case2 = robRange(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    public int robRange(int[] nums, int start, int end) {

        int n = end - start + 1;

        if (n == 1) {
            return nums[start];
        }

        int[] dp = new int[n];

        dp[0] = nums[start];

        dp[1] = Math.max(
                nums[start],
                nums[start + 1]
        );

        for (int i = 2; i < n; i++) {

            dp[i] = Math.max(
                    dp[i - 1],
                    dp[i - 2] + nums[start + i]
            );
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        HouseRobberII obj = new HouseRobberII();

        int[] nums = {2, 3, 2};

        int result = obj.rob(nums);

        System.out.println("Maximum Money: " + result);
    }
}