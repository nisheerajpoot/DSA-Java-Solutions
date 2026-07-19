package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /*
      Platform : LeetCode

      Question : Palindrome Partitioning

      Pattern  : Backtracking

      Approach :
      Partition Based Backtracking

      Idea :
      - Start partitioning the string
        from index 0.
      - Try every possible substring
        starting from the current index.
      - If the substring is a palindrome,
        choose it and add it to the
        current partition.
      - Recursively partition the
        remaining part of the string.
      - Remove the last substring
        (Backtrack) and try the
        next possible partition.
      - When the entire string is
        partitioned, store the
        current partition.

      Time Complexity :
      O(2ⁿ × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        backtrack(0,
                  s,
                  new ArrayList<>(),
                  ans);

        return ans;
    }

    private void backtrack(int start,
                           String s,
                           List<String> current,
                           List<List<String>> ans) {

        // Base Case
        if (start == s.length()) {

            ans.add(new ArrayList<>(current));

            return;
        }

        // Try Every Possible Partition
        for (int end = start; end < s.length(); end++) {

            // Choose Only Palindromes
            if (isPalindrome(s, start, end)) {

                current.add(s.substring(start, end + 1));

                // Explore
                backtrack(end + 1,
                          s,
                          current,
                          ans);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s,
                                 int left,
                                 int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        PalindromePartitioning obj =
                new PalindromePartitioning();

        String s = "aab";

        List<List<String>> result =
                obj.partition(s);

        System.out.println("Palindrome Partitions :");

        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}