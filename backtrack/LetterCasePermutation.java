package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    /*
      Platform : LeetCode

      Question : Letter Case Permutation

      Pattern  : Backtracking

      Approach :
      Choice Based Backtracking

      Idea :
      - Process one character at a time.
      - If the current character is
        a letter, we have two choices:
          1. Convert it to lowercase.
          2. Convert it to uppercase.
      - If the current character is
        a digit, keep it unchanged.
      - Continue recursively for the
        next character.
      - When all characters are
        processed, store the current
        permutation.

      Time Complexity :
      O(2ⁿ × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {

        solve(s, 0, "");

        return ans;
    }

    private void solve(String s,
                       int index,
                       String res) {

        // Base Case
        if (index == s.length()) {

            ans.add(res);

            return;
        }

        char ch = s.charAt(index);

        // Two Choices for Letters
        if (Character.isLetter(ch)) {

            // Lowercase
            solve(s,
                  index + 1,
                  res + Character.toLowerCase(ch));

            // Uppercase
            solve(s,
                  index + 1,
                  res + Character.toUpperCase(ch));
        }

        // Only One Choice for Digits
        else {

            solve(s,
                  index + 1,
                  res + ch);
        }
    }

    public static void main(String[] args) {

        LetterCasePermutation obj =
                new LetterCasePermutation();

        String s = "a1b2";

        List<String> result =
                obj.letterCasePermutation(s);

        System.out.println("Letter Case Permutations :");

        for (String str : result) {
            System.out.println(str);
        }
    }
}
