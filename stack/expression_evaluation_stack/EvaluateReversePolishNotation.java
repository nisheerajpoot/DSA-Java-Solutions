package expression_evaluation_stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    /*
      Platform : LeetCode
      Question : Evaluate Reverse Polish Notation (150)
      Pattern  : Expression Evaluation Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a + b);

            } else if (token.equals("-")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a - b);

            } else if (token.equals("*")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a * b);

            } else if (token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a / b);

            } else {

                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();

        String[] tokens = {"2", "1", "+", "3", "*"};

        System.out.println(obj.evalRPN(tokens));
        // Output: 9
    }
}