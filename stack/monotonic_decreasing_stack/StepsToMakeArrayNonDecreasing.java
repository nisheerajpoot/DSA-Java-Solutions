package stack.monotonic_decreasing_stack;

import java.util.Stack;

public class StepsToMakeArrayNonDecreasing {

    /*
      Platform : LeetCode
      Question : Steps to Make Array Non-decreasing
      Pattern  : Monotonic Decreasing Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int totalSteps(int[] nums) {

        int n = nums.length;

        Stack<int[]> st = new Stack<>();

        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {

            int steps = 0;

            while (!st.isEmpty() && nums[i] > st.peek()[0]) {

                steps = Math.max(steps + 1, st.peek()[1]);

                st.pop();
            }

            ans = Math.max(ans, steps);
            // [value, steps]
            st.push(new int[]{nums[i], steps});
        }

        return ans;
    }

    public static void main(String[] args) {

        StepsToMakeArrayNonDecreasing obj =
                new StepsToMakeArrayNonDecreasing();

        int[] nums = {5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};

        System.out.println(obj.totalSteps(nums));
    }
}