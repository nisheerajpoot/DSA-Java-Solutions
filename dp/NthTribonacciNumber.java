package dp;

public class NthTribonacciNumber {

    /*
     * ============================================================
     * Problem   : N-th Tribonacci Number
     * Platform  : LeetCode 1137
     * Pattern   : 1D DP - Tabulation
     *
     * Approach:
     * Tribonacci sequence:
     *
     * T(n) = T(n - 1) + T(n - 2) + T(n - 3)
     *
     * Base Cases:
     * T(0) = 0
     * T(1) = 1
     * T(2) = 1
     *
     * We store every Tribonacci value in the dp array.
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     * ============================================================
     */

    public int tribonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {

            dp[i] = dp[i - 1]
                    + dp[i - 2]
                    + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        NthTribonacciNumber obj =
                new NthTribonacciNumber();

        int n = 5;

        int result = obj.tribonacci(n);

        System.out.println(
                "Tribonacci of " + n + " = " + result
        );
    }
}