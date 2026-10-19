package dp;

/*
 * Platform: LeetCode
 * Problem: Last Stone Weight II
 * Problem Number: 1049
 * Pattern: 0/1 Knapsack / Subset Sum
 *
 * Approach:
 * 1. Calculate the total weight of all stones.
 * 2. Set target = total / 2.
 * 3. Use 1D DP to find the maximum subset sum
 *    that does not exceed target.
 * 4. Calculate the minimum possible remaining weight
 *    using total - 2 * dp[target].
 *
 * Time Complexity: O(n * target)
 * Space Complexity: O(target)
 */

public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {

        int total = 0;

        for (int stone : stones) {
            total += stone;
        }

        int target = total / 2;

        int[] dp = new int[target + 1];

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        return total - 2 * dp[target];
    }

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};

        LastStoneWeightII obj = new LastStoneWeightII();

        int result = obj.lastStoneWeightII(stones);

        System.out.println("Minimum Remaining Stone Weight: " + result);
    }
}