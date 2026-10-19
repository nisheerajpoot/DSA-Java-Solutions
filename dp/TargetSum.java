package dp;

/*
 * Platform: LeetCode
 * Problem: Target Sum
 * Problem Number: 494
 * Pattern: 0/1 Knapsack / Subset Sum DP
 *
 * Approach:
 * 1. Calculate the total sum of all numbers.
 * 2. Check whether the target is possible.
 * 3. Convert the problem into counting subsets
 *    whose sum equals (total + target) / 2.
 * 4. Use 1D DP to count the subsets.
 * 5. Traverse the DP array backwards to ensure
 *    each number is used at most once.
 *
 * Time Complexity: O(n * sum)
 * Space Complexity: O(sum)
 */

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (Math.abs(target) > total) {
            return 0;
        }

        if ((total + target) % 2 != 0) {
            return 0;
        }

        int sum = (total + target) / 2;

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        TargetSum obj = new TargetSum();

        int result = obj.findTargetSumWays(nums, target);

        System.out.println("Number of Ways: " + result);
    }
}