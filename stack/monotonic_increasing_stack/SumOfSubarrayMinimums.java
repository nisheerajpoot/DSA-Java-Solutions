package stack.monotonic_increasing_stack;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    /*
      Platform : LeetCode
      Question : Sum of Subarray Minimums
      Pattern  : Monotonic Increasing Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;

        long mod = 1000000007;

        int[] prevSmaller = new int[n];

        int[] nextSmaller = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                prevSmaller[i] = -1;
            }
            else {
                prevSmaller[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();
// Next Smaller Element ka index[1,4,4,4]
        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                nextSmaller[i] = n;
            }
            else {
                nextSmaller[i] = st.peek();
            }

            st.push(i);
        }

        long ans = 0;

        for(int i = 0; i < n; i++) {

            long left = i - prevSmaller[i];

            long right = nextSmaller[i] - i;

            long contribution = (arr[i] * left * right) % mod;

            ans = (ans + contribution) % mod;
        }

        return (int) ans;
    }

    public static void main(String[] args) {

        SumOfSubarrayMinimums obj =
                new SumOfSubarrayMinimums();

        int[] arr = {3, 1, 2, 4};

        System.out.println(obj.sumSubarrayMins(arr));
    }
}