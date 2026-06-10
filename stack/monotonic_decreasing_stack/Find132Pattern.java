package stack.monotonic_decreasing_stack;

import java.util.Stack;

public class Find132Pattern {

    /*
      Platform : LeetCode
      Question : 132 Pattern
      Pattern  : Monotonic Decreasing Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public boolean find132pattern(int[] nums) {

        Stack<Integer> st = new Stack<>();

        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < third) {
                return true;
            }

            while (!st.isEmpty() && nums[i] > st.peek()) {
                third = st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        Find132Pattern obj = new Find132Pattern();

        int[] nums = {3, 1, 4, 2};

        System.out.println(obj.find132pattern(nums));
    }
}