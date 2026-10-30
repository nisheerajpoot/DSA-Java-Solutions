
package dp;

/*
 * Platform: GeeksforGeeks
 * Problem: Longest Common Substring
 * Pattern: 2D DP / String DP
 *
 * Approach:
 * 1. dp[i][j] stores the length of the common
 *    substring ending at s1[i-1] and s2[j-1].
 * 2. If characters match, add 1 to dp[i-1][j-1].
 * 3. If characters do not match, set dp[i][j] = 0.
 * 4. Track the maximum length found.
 * 5. Return maxLength.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

public class LongestCommonSubstring {

    public int longCommSubstr(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s1 = "ABCDGH";
        String s2 = "ACDGHR";

        LongestCommonSubstring obj = new LongestCommonSubstring();

        int result = obj.longCommSubstr(s1, s2);

        System.out.println("Longest Common Substring Length: " + result);
    }
}
