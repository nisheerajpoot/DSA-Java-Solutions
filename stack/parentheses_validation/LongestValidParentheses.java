package stack.parentheses_validation;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        Stack<Integer> st = new Stack<>();

        st.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            }

            // Closing bracket
            else {

                st.pop();

                if (st.isEmpty()) {
                    st.push(i);
                }
                else {
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        LongestValidParentheses obj =
                new LongestValidParentheses();

        int ans = obj.longestValidParentheses(s);

        System.out.println("Longest valid parentheses length: " + ans);

        sc.close();
    }
}