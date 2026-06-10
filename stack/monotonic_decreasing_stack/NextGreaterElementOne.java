package stack.monotonic_decreasing_stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementOne {

    /*
      Platform : LeetCode
      Question : Next Greater Element I
      Pattern  : Monotonic Decreasing Stack

      Time Complexity  : O(n²)
      Space Complexity : O(n)
    */

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;

        int[] nextGreater = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nextGreater[i] = -1;
            } 
            else {
                nextGreater[i] = st.peek();
            }

            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    ans[i] = nextGreater[j];
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        NextGreaterElementOne obj = new NextGreaterElementOne();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        System.out.println(Arrays.toString(obj.nextGreaterElement(nums1, nums2)));
    }
}