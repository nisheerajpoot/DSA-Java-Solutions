package stack.index_stack;

import java.util.Stack;

public class MakeTheStringGreat {

    /*
      Platform : LeetCode
      Question : Make The String Great
      Pattern  : Index Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public String makeGood(String s) {

        char[] arr = s.toCharArray();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (!st.isEmpty() &&
                Math.abs(arr[st.peek()] - arr[i]) == 32) {

                st.pop();
            }
            else {
                st.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int idx : st) {
            sb.append(arr[idx]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        MakeTheStringGreat obj = new MakeTheStringGreat();

        String s = "leEeetcode";

        System.out.println(obj.makeGood(s));
    }
}