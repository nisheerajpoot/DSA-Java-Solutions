package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AllSubsequencesOfAString {

    /*
      Platform : GeeksforGeeks

      Question : All Subsequences of a String

      Pattern  : Recursion + Backtracking

      Approach :
      Include / Exclude

      Idea :
      - For every character, there are
        two choices:
          1. Include the character in the
             current subsequence.
          2. Exclude the character.
      - When all characters have been
        processed, store the current
        subsequence.
      - Finally, sort all subsequences
        lexicographically.

      Time Complexity :
      O(n × 2^n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<String> allSubsequences(String s) {

        List<String> ans = new ArrayList<>();

        solve(0, s, new StringBuilder(), ans);

        Collections.sort(ans);

        return ans;
    }

    private void solve(int index, String s,
                       StringBuilder curr,
                       List<String> ans) {

        // Base Case
        if (index == s.length()) {
            ans.add(curr.toString());
            return;
        }

        // Include Current Character
        curr.append(s.charAt(index));
        solve(index + 1, s, curr, ans);

        // Backtrack
        curr.deleteCharAt(curr.length() - 1);

        // Exclude Current Character
        solve(index + 1, s, curr, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        AllSubsequencesOfAString obj =
                new AllSubsequencesOfAString();

        List<String> ans = obj.allSubsequences(s);

        System.out.println(ans);

        sc.close();
    }
}
