package stack.index_stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    /*
      Platform : LeetCode
      Question : Remove All Adjacent Duplicates In String
      Pattern  : Index Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public String removeDuplicates(String s) {

        char[] arr = s.toCharArray();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (!st.isEmpty() && arr[st.peek()] == arr[i]) {
                st.pop();
            }
            else {
                st.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int idx : st) {
            sb.append(arr[idx]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        RemoveAllAdjacentDuplicatesInString obj =
                new RemoveAllAdjacentDuplicatesInString();

        String s = "abbaca";

        System.out.println(obj.removeDuplicates(s));
    }
}