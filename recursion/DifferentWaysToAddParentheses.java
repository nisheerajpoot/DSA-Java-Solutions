package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentWaysToAddParentheses {

    /*
      Platform : LeetCode

      Question : Different Ways to Add Parentheses

      Pattern  : Recursion + Divide and Conquer

      Approach :
      Split at Every Operator

      Idea :
      - Traverse the expression.
      - Whenever an operator is found,
        split the expression into:
          • Left part
          • Right part
      - Recursively compute all possible
        results for both parts.
      - Combine every left result with
        every right result using the
        current operator.
      - If no operator exists,
        the expression is a single number,
        which becomes the base case.

      Time Complexity :
      Exponential

      (Approximately O(2^n))

      Space Complexity :
      O(n)

      (Recursive Call Stack)

      Note :
      This solution can be optimized
      using Memoization to avoid solving
      the same subexpression multiple times.
    */

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {

                String leftExpression =
                        expression.substring(0, i);

                String rightExpression =
                        expression.substring(i + 1);

                List<Integer> left =
                        diffWaysToCompute(leftExpression);

                List<Integer> right =
                        diffWaysToCompute(rightExpression);

                // Combine Results
                for (int l : left) {

                    for (int r : right) {

                        if (ch == '+') {
                            ans.add(l + r);
                        } else if (ch == '-') {
                            ans.add(l - r);
                        } else {
                            ans.add(l * r);
                        }
                    }
                }
            }
        }

        // Base Case
        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        DifferentWaysToAddParentheses obj =
                new DifferentWaysToAddParentheses();

        List<Integer> ans =
                obj.diffWaysToCompute(expression);

        System.out.println(ans);

        sc.close();
    }
}