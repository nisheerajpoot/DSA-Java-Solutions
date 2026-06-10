package  stack.parentheses_validation;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            else {

                if (st.isEmpty()) {
                    return false;
                }

                if (ch == ')' && st.peek() == '(') {
                    st.pop();
                }
                else if (ch == '}' && st.peek() == '{') {
                    st.pop();
                }
                else if (ch == ']' && st.peek() == '[') {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        ValidParentheses obj = new ValidParentheses();

        boolean ans = obj.isValid(s);

        System.out.println(ans);

        sc.close();
    }
}