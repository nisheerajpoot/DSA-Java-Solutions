package stack.monotonic_increasing_stack;

import java.util.Arrays;
import java.util.Stack;

public class FinalPrices {

    /*
      Platform : LeetCode
      Question : Final Prices With a Special Discount in a Shop
      Pattern  : Monotonic Increasing Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int[] finalPrices(int[] prices) {

        int n = prices.length;

        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && st.peek() > prices[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                res[i] = prices[i];
            } 
            else {
                res[i] = prices[i] - st.peek();
            }

            st.push(prices[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        FinalPrices obj = new FinalPrices();

        int[] prices = {8, 4, 6, 2, 3};

        int[] ans = obj.finalPrices(prices);

        System.out.println(Arrays.toString(ans));
    }
}