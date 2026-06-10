package stack.simulation_with_stack;

import java.util.Stack;

public class BaseballGame {

    /*
      Platform : LeetCode
      Question : Baseball Game
      Pattern  : Simulation With Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();

        for (String op : operations) {

            if (op.equals("+")) {

                int top = st.pop();

                int newScore = top + st.peek();

                st.push(top);

                st.push(newScore);
            }
            else if (op.equals("D")) {

                st.push(2 * st.peek());
            }
            else if (op.equals("C")) {

                st.pop();
            }
            else {

                st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        while (!st.isEmpty()) {

            sum += st.pop();
        }

        return sum;
    }

    public static void main(String[] args) {

        BaseballGame obj = new BaseballGame();

        String[] operations = {"5", "2", "C", "D", "+"};

        System.out.println(obj.calPoints(operations));
    }
}