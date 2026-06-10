package  stack.parentheses_validation;

import java.util.Scanner;
import java.util.Stack;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {

        Stack<Character> st = new Stack<>();

        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray()) {

            // Opening bracket
            if (ch == '(') {

                if (!st.isEmpty()) {
                    ans.append(ch);
                }

                st.push(ch);
            }

            // Closing bracket
            else {

                st.pop();

                if (!st.isEmpty()) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        RemoveOutermostParentheses obj =
                new RemoveOutermostParentheses();

        String ans = obj.removeOuterParentheses(s);

        System.out.println("After removing outermost parentheses: " + ans);

        sc.close();
    }
}