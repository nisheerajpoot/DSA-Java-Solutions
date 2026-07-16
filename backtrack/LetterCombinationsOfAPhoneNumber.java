package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    /*
      Platform : LeetCode

      Question : Letter Combinations of a Phone Number

      Pattern  : Backtracking

      Approach :
      Choice Based Backtracking

      Idea :
      - Each digit maps to a set of
        characters on a phone keypad.
      - Process one digit at a time.
      - For the current digit,
        try every possible letter.
      - Add the chosen letter to the
        current combination.
      - Recursively process the next
        digit.
      - Remove the last letter
        (Backtrack) and try the
        next possible letter.
      - When all digits are processed,
        store the current combination.

      Time Complexity :
      O(4ⁿ × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    private final String[] map = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        backtrack(0, digits,
                  new StringBuilder(), ans);

        return ans;
    }

    private void backtrack(int index,
                           String digits,
                           StringBuilder current,
                           List<String> ans) {

        // Base Case
        if (index == digits.length()) {

            ans.add(current.toString());

            return;
        }

        String letters =
                map[digits.charAt(index) - '0'];

        // Try Every Letter
        for (int i = 0; i < letters.length(); i++) {

            // Choose
            current.append(letters.charAt(i));

            // Explore
            backtrack(index + 1,
                      digits,
                      current,
                      ans);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        LetterCombinationsOfAPhoneNumber obj =
                new LetterCombinationsOfAPhoneNumber();

        String digits = "23";

        List<String> result =
                obj.letterCombinations(digits);

        System.out.println("Letter Combinations :");

        for (String str : result) {
            System.out.println(str);
        }
    }
}