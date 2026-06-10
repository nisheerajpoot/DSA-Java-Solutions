package stack.simulation_with_stack;

import java.util.Stack;

public class RemovingStarsFromAString {

    /*
      Platform : LeetCode
      Question : Removing Stars From a String
      Pattern  : Simulation With Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public String removeStars(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '*') {
                st.pop();
            }
            else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        RemovingStarsFromAString obj =
                new RemovingStarsFromAString();

        String s = "leet**cod*e";

        System.out.println(obj.removeStars(s));
    }
}