package stack.monotonic_increasing_stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {

    /*
      Platform : GFG
      Question : Next Smaller Element
      Pattern  : Monotonic Increasing Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    static ArrayList<Integer> nextSmallerEle(int[] arr) {

        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                res[i] = -1;
            } 
            else {
                res[i] = st.peek();
            }

            st.push(arr[i]);
        }

        for(int num : res) {
            ans.add(num);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 5, 2, 25};

        ArrayList<Integer> ans = nextSmallerEle(arr);

        System.out.println(ans);
    }
}