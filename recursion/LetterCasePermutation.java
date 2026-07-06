package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCasePermutation {

    /*
      Platform : LeetCode

      Question : Letter Case Permutation

      Pattern  : Recursion + Backtracking

      Approach :
      Character Choice Recursion

      Idea :
      - Process the string one character
        at a time.
      - If the current character is a letter,
        there are two choices:
          • Convert it to lowercase.
          • Convert it to uppercase.
      - If the current character is a digit,
        there is only one choice:
          • Keep it unchanged.
      - When all characters have been
        processed, store the generated
        string.

      Time Complexity :
      O(n × 2^L)

      where L = Number of letters

      Space Complexity :
      O(n)

      (Recursive Call Stack)

      Note :
      If output space is considered,
      the total space complexity becomes
      O(n × 2^L).
    */

    private List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {

        solve(s, 0, "");

        return ans;
    }

    private void solve(String s,
                       int index,
                       String current) {

        // Base Case
        if (index == s.length()) {

            ans.add(current);
            return;
        }

        char ch = s.charAt(index);

        // Letter
        if (Character.isLetter(ch)) {

            // Lowercase
            solve(s,
                  index + 1,
                  current + Character.toLowerCase(ch));

            // Uppercase
            solve(s,
                  index + 1,
                  current + Character.toUpperCase(ch));
        }

        // Digit
        else {

            solve(s,
                  index + 1,
                  current + ch);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        LetterCasePermutation obj = new LetterCasePermutation();

        List<String> ans = obj.letterCasePermutation(s);

        System.out.println(ans);

        sc.close();
    }
}