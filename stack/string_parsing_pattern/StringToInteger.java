package stack.string_parsing_pattern;

import java.util.Stack;

public class StringToInteger {

    /*
      Platform : LeetCode
      Question : String to Integer (atoi) (8)
      Pattern  : String Parsing

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int myAtoi(String s) {

        int index = 0;
        int n = s.length();

        // Step 1: Skip leading spaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Handle sign
        int sign = 1;

        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {

            if (s.charAt(index) == '-') {
                sign = -1;
            }

            index++;
        }

        // Step 3: Collect digits
        Stack<Character> stack = new Stack<>();

        while (index < n && Character.isDigit(s.charAt(index))) {
            stack.push(s.charAt(index));
            index++;
        }

        // No digits found
        if (stack.isEmpty()) {
            return 0;
        }

        // Step 4: Build digit string
        StringBuilder digits = new StringBuilder();

        while (!stack.isEmpty()) {
            digits.append(stack.pop());
        }

        digits.reverse();

        // Step 5: Convert to number with overflow handling
        long result = 0;

        for (int i = 0; i < digits.length(); i++) {

            int digit = digits.charAt(i) - '0';

            result = result * 10 + digit;

            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {

        StringToInteger obj = new StringToInteger();

        String s = "   -42";

        System.out.println(obj.myAtoi(s));
        // Output: -42
    }
}