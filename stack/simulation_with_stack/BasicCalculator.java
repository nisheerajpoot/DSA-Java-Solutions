package stack.simulation_with_stack;

import java.util.Stack;

public class BasicCalculator {

    /*
      Platform : LeetCode
      Question : Basic Calculator
      Pattern  : Simulation With Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');
            }

            else if (ch == '+') {

                result += sign * number;
                number = 0;
                sign = 1;
            }

            else if (ch == '-') {

                result += sign * number;
                number = 0;
                sign = -1;
            }

            else if (ch == '(') {

                st.push(result);
                st.push(sign);

                result = 0;
                sign = 1;
            }

            else if (ch == ')') {

                result += sign * number;
                number = 0;

                result *= st.pop();
                result += st.pop();
            }
        }

        result += sign * number;

        return result;
    }

    public static void main(String[] args) {

        BasicCalculator obj = new BasicCalculator();

        String s = "(1+(4+5+2)-3)+(6+8)";

        System.out.println(obj.calculate(s));
    }
}