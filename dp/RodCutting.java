package dp;

/*
 * Platform: GeeksforGeeks
 * Problem: Rod Cutting
 * Pattern: 1D DP / Unbounded Knapsack
 *
 * Approach:
 * 1. dp[length] stores the maximum profit for a rod
 *    of the given length.
 * 2. Try every possible cut from 1 to length.
 * 3. Calculate the profit using:
 *    price[cut - 1] + dp[length - cut]
 * 4. Store the maximum profit in dp[length].
 * 5. Return dp[n].
 *
 * Time Complexity: O(n * n)
 * Space Complexity: O(n)
 */

public class RodCutting {

    public int cutRod(int[] price) {

        int n = price.length;

        int[] dp = new int[n + 1];

        for (int length = 1; length <= n; length++) {
            for (int cut = 1; cut <= length; cut++) {

                dp[length] = Math.max(
                    dp[length],
                    price[cut - 1] + dp[length - cut]
                );
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        RodCutting obj = new RodCutting();

        int result = obj.cutRod(price);

        System.out.println("Maximum Profit: " + result);
    }
}