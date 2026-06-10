package stack.two_stack_design_pattern;

import java.util.Scanner;
import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {

        Stack<Character> st1 = check(s);
        Stack<Character> st2 = check(t);

        return st1.equals(st2);
    }

    private Stack<Character> check(String str) {

        Stack<Character> st = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch != '#') {
                st.push(ch);
            }
            else {

                if (!st.isEmpty()) {
                    st.pop();
                }
            }
        }

        return st;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BackspaceStringCompare obj =
                new BackspaceStringCompare();

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        System.out.println(obj.backspaceCompare(s, t));

        sc.close();
    }
}