package stack.monotonic_increasing_stack;

import java.util.Stack;

public class RemoveKDigits {

    /*
      Platform : LeetCode
      Question : Remove K Digits
      Pattern  : Monotonic Increasing Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for(char c : num.toCharArray()) {

            while(!st.isEmpty() && k > 0 && st.peek() > c) {

                st.pop();

                k--;
            }

            st.push(c);
        }

        while(k > 0 && !st.isEmpty()) {

            st.pop();

            k--;
        }

        StringBuilder sb = new StringBuilder();

        for(char c : st) {
            sb.append(c);
        }

        while(sb.length() > 0 && sb.charAt(0) == '0') {

            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {

        RemoveKDigits obj = new RemoveKDigits();

        String num = "1432219";

        int k = 3;

        System.out.println(obj.removeKdigits(num, k));
    }
}