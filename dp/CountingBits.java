package dp;

import java.util.Arrays;

public class CountingBits {

    /*
     * ============================================================
     * Problem   : Counting Bits
     * Platform  : LeetCode 338
     * Pattern   : 1D DP
     *
     * Approach:
     * dp[i] = number of 1s in the binary representation of i.
     *
     * For every number i:
     *
     * i / 2  -> removes the last binary bit
     * i % 2  -> tells whether the last bit is 0 or 1
     *
     * Therefore:
     *
     * dp[i] = dp[i / 2] + (i % 2)
     *
     * Example:
     *
     * i = 5
     * Binary = 101
     *
     * 5 / 2 = 2  -> Binary 10
     * 5 % 2 = 1  -> Last bit is 1
     *
     * dp[5] = dp[2] + 1
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     * ============================================================
     */

    public int[] countBits(int n) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            dp[i] = dp[i / 2] + (i % 2);
        }

        return dp;
    }

    public static void main(String[] args) {

        CountingBits obj = new CountingBits();

        int n = 5;

        int[] result = obj.countBits(n);

        System.out.println("Number of set bits:");

        System.out.println(Arrays.toString(result));
    }
}