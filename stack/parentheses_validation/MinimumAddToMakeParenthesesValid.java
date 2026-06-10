package  stack.parentheses_validation;

import java.util.Scanner;
import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {

        Stack<Character> st = new Stack<>();

        int add = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(ch);
            }

            else {

                if (!st.isEmpty()) {
                    st.pop();
                }
                else {
                    add++;
                }
            }
        }

        return st.size() + add;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        MinimumAddToMakeParenthesesValid obj =
                new MinimumAddToMakeParenthesesValid();

        int ans = obj.minAddToMakeValid(s);

        System.out.println("Minimum additions required: " + ans);

        sc.close();
    }
}