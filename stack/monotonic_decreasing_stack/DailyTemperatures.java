package stack.monotonic_decreasing_stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    /*
      Platform : LeetCode
      Question : Daily Temperatures
      Pattern  : Monotonic Decreasing Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                   temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = 0;
            }
            else {
                ans[i] = st.peek() - i;
            }

            st.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        DailyTemperatures obj = new DailyTemperatures();

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(
                Arrays.toString(obj.dailyTemperatures(temperatures))
        );
    }
}