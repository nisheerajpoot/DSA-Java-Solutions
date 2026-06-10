package  stack.parentheses_validation;

import java.util.Scanner;
import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(0);
            }

            else {

                int top = st.pop();

                int score = Math.max(2 * top, 1);

                st.push(st.pop() + score);
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        ScoreOfParentheses obj = new ScoreOfParentheses();

        int ans = obj.scoreOfParentheses(s);

        System.out.println("Score of Parentheses: " + ans);

        sc.close();
    }
}