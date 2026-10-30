package dp;

/*
 * Platform: LeetCode
 * Problem: Longest Common Subsequence
 * Problem Number: 1143
 * Pattern: 2D DP / String DP
 *
 * Approach:
 * 1. dp[i][j] stores the length of the LCS
 *    between the first i characters of text1
 *    and the first j characters of text2.
 * 2. If characters match, add 1 to dp[i-1][j-1].
 * 3. Otherwise, take the maximum of dp[i-1][j]
 *    and dp[i][j-1].
 * 4. Return dp[m][n].
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence obj = new LongestCommonSubsequence();

        int result = obj.longestCommonSubsequence(text1, text2);

        System.out.println("Longest Common Subsequence Length: " + result);
    }
}
