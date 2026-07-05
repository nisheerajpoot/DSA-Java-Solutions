package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {

    /*
      Platform : LeetCode

      Question : Generate Parentheses

      Pattern  : Recursion + Backtracking

      Approach :
      Valid Parentheses Construction

      Idea :
      - Build the answer one character
        at a time.
      - Keep track of:
          • Number of opening brackets.
          • Number of closing brackets.
      - Add '(' only if the number of
        opening brackets is less than n.
      - Add ')' only if the number of
        closing brackets is less than
        the number of opening brackets.
      - When the string length becomes
        2 × n, a valid combination is
        formed and added to the answer.

      Time Complexity :
      O(4^n / √n)

      (Catalan Number)

      Space Complexity :
      O(n)

      (Recursive Call Stack)

      Note :
      If output space is considered,
      the total space complexity becomes
      O(Cn × n), where Cn is the nth
      Catalan number.
    */

    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        solve("", 0, 0, n);

        return ans;
    }

    private void solve(String current,
                       int open,
                       int close,
                       int n) {

        // Base Case
        if (current.length() == 2 * n) {

            ans.add(current);
            return;
        }

        // Add Opening Parenthesis
        if (open < n) {
            solve(current + "(", open + 1, close, n);
        }

        // Add Closing Parenthesis
        if (close < open) {
            solve(current + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        GenerateParentheses obj = new GenerateParentheses();

        List<String> ans = obj.generateParenthesis(n);

        System.out.println(ans);

        sc.close();
    }
}