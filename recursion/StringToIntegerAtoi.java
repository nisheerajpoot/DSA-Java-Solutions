package recursion;

import java.util.Scanner;

public class StringToIntegerAtoi {

    /*
      Platform : LeetCode

      Question : String to Integer (atoi)

      Pattern  : Recursion

      Approach :
      Recursive String Parsing

      Idea :
      - Skip all leading spaces.
      - Check for an optional '+' or '-'
        sign.
      - Recursively process each digit.
      - Build the number as:
            result = result * 10 + digit
      - Stop recursion when a non-digit
        character or the end of the string
        is reached.
      - Check for integer overflow while
        constructing the number.
      - Return the final signed result.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    private int sign = 1;
    private long result = 0;

    public int myAtoi(String s) {

        int index = 0;
        int n = s.length();

        // Skip Leading Spaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index == n) {
            return 0;
        }

        // Check Sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {

            if (s.charAt(index) == '-') {
                sign = -1;
            }

            index++;
        }

        solve(s, index);

        return (int) (sign * result);
    }

    private void solve(String s, int index) {

        // Base Case
        if (index >= s.length() ||
            !Character.isDigit(s.charAt(index))) {
            return;
        }

        int digit = s.charAt(index) - '0';

        result = result * 10 + digit;

        // Positive Overflow
        if (sign == 1 && result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
            return;
        }

        // Negative Overflow
        if (sign == -1 && -result < Integer.MIN_VALUE) {
            result = -(long) Integer.MIN_VALUE;
            return;
        }

        // Recursive Call
        solve(s, index + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        StringToIntegerAtoi obj = new StringToIntegerAtoi();

        System.out.println(obj.myAtoi(s));

        sc.close();
    }
}