package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubsequencesOfAString {

    /*
      Platform : GeeksforGeeks

      Question : All Subsequences of a String

      Pattern  : Backtracking

      Approach :
      Pick / Not Pick

      Idea :
      - At every character,
        we have two choices:
          1. Include the character.
          2. Exclude the character.
      - Continue recursively until
        all characters are processed.
      - When the end of the string
        is reached, store the current
        subsequence.
      - Finally, sort all subsequences
        before returning.

      Time Complexity :
      O(2ⁿ × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<String> powerSet(String s) {

        List<String> ans = new ArrayList<>();

        solve(0, s, new StringBuilder(), ans);

        Collections.sort(ans);

        return ans;
    }

    private void solve(int index,
                       String s,
                       StringBuilder curr,
                       List<String> ans) {

        // Base Case
        if (index == s.length()) {

            ans.add(curr.toString());

            return;
        }

        // Pick Current Character
        curr.append(s.charAt(index));

        solve(index + 1, s, curr, ans);

        // Backtrack
        curr.deleteCharAt(curr.length() - 1);

        // Not Pick Current Character
        solve(index + 1, s, curr, ans);
    }

    public static void main(String[] args) {

        AllSubsequencesOfAString obj =
                new AllSubsequencesOfAString();

        String s = "abc";

        List<String> result = obj.powerSet(s);

        System.out.println("All Subsequences :");

        for (String str : result) {
            System.out.println("\"" + str + "\"");
        }
    }
}