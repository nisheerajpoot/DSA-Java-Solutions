package stack.monotonic_decreasing_stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementTwo {

    /*
      Platform : LeetCode
      Question : Next Greater Element II
      Pattern  : Monotonic Decreasing Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {

            int idx = i % n;

            while (!st.isEmpty() && nums[st.peek()] <= nums[idx]) {
                st.pop();
            }

            if (i < n) {

                if (st.isEmpty()) {
                    ans[idx] = -1;
                }
                else {
                    ans[idx] = nums[st.peek()];
                }
            }

            st.push(idx);
        }

        return ans;
    }

    public static void main(String[] args) {

        NextGreaterElementTwo obj =
                new NextGreaterElementTwo();

        int[] nums = {1, 2, 1};

        System.out.println(
                Arrays.toString(obj.nextGreaterElements(nums))
        );
    }
}