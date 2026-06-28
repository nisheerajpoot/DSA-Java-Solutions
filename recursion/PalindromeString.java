package recursion;

import java.util.Scanner;

public class PalindromeString {

    /*
      Platform : GeeksforGeeks

      Question : Palindrome String

      Pattern  : Recursion

      Approach :
      Recursive Two-Pointer

      Idea :
      - Convert the string to lowercase.
      - If the string has 0 or 1 character,
        it is a palindrome.
      - Compare the first and last characters.
      - If they are different, return false.
      - Otherwise, recursively check the
        remaining substring.

      Time Complexity :
      O(n²)

      Space Complexity :
      O(n)

      (Recursive Call Stack)

      Note :
      Using substring() creates a new string
      in every recursive call, making the
      overall time complexity O(n²).
    */

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();

        // Base Case
        if (s.length() <= 1) {
            return true;
        }

        // Characters do not match
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        // Recursive Relation
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(isPalindrome(s));

        sc.close();
    }
}