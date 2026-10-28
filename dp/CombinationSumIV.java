```java
package dp;

/*
 * Platform: LeetCode
 * Problem: Combination Sum IV
 * Problem Number: 377
 * Pattern: 1D DP / Ordered Combinations
 *
 * Approach:
 * 1. dp[i] stores the number of combinations that sum to i.
 * 2. Initialize dp[0] = 1.
 * 3. Traverse each target value from 1 to target.
 * 4. For each number, add dp[i - num] if i >= num.
 * 5. Return dp[target].
 *
 * Time Complexity: O(target * n)
 * Space Complexity: O(target)
 */

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;

        CombinationSumIV obj = new CombinationSumIV();

        int result = obj.combinationSum4(nums, target);

        System.out.println("Number of Combinations: " + result);
    }
}
```