package dp;

import java.util.Arrays;

/*
 * Platform: LeetCode
 * Problem: Coin Change
 * Problem Number: 322
 * Pattern: Dynamic Programming - Unbounded Knapsack
 *
 * Approach:
 * 1. Create a DP array of size amount + 1.
 * 2. Initialize all values to amount + 1 (impossible initially).
 * 3. Set dp[0] = 0 because zero coins are needed for amount 0.
 * 4. For every amount, try every coin and minimize
 *    the number of coins required.
 * 5. Return -1 if the amount cannot be formed.
 *
 * Time Complexity: O(amount * coins.length)
 * Space Complexity: O(amount)
 */

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        CoinChange obj = new CoinChange();

        int result = obj.coinChange(coins, amount);

        System.out.println("Minimum Coins Required: " + result);
    }
}