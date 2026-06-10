package stack.expression_evaluation_stack;

import java.util.Stack;

public class BasicCalculatorII {

    /*
      Platform : LeetCode
      Question : Basic Calculator II (227)
      Pattern  : Expression Evaluation Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (op == '+') {
                    stack.push(num);
                }
                else if (op == '-') {
                    stack.push(-num);
                }
                else if (op == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (op == '/') {
                    stack.push(stack.pop() / num);
                }

                op = ch;
                num = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        BasicCalculatorII obj = new BasicCalculatorII();

        String s = "3+2*2";

        System.out.println(obj.calculate(s));
        // Output: 7
    }
}