package dp;

/*
 * Platform: LeetCode
 * Problem: Coin Change II
 * Problem Number: 518
 * Pattern: 1D DP / Unbounded Knapsack
 *
 * Approach:
 * 1. dp[i] stores the number of ways to make amount i.
 * 2. Initialize dp[0] = 1.
 * 3. Process each coin.
 * 4. Update dp from coin to amount.
 * 5. Return dp[amount].
 *
 * Time Complexity: O(n * amount)
 * Space Complexity: O(amount)
 */

public class CoinChangeII {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        int amount = 5;
        int[] coins = {1, 2, 5};

        CoinChangeII obj = new CoinChangeII();

        int result = obj.change(amount, coins);

        System.out.println("Number of Ways: " + result);
    }
}
