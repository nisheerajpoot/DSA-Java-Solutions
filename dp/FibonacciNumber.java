package dp;

public class FibonacciNumber {

    /*
     * ============================================================
     * Problem   : Fibonacci Number
     * Platform  : LeetCode 509
     * Pattern   : 1D DP - Tabulation
     *
     * Approach:
     * Fibonacci series:
     *
     * fib(n) = fib(n - 1) + fib(n - 2)
     *
     * Base Cases:
     * fib(0) = 0
     * fib(1) = 1
     *
     * We store every Fibonacci value in the dp array.
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     * ============================================================
     */

    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        FibonacciNumber obj = new FibonacciNumber();

        int n = 6;

        int result = obj.fib(n);

        System.out.println("Fibonacci of " + n + " = " + result);
    }
}