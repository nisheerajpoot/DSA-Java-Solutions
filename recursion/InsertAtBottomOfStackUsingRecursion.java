package recursion;

import java.util.Stack;

public class InsertAtBottomOfStackUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Insert an Element at the Bottom of a Stack

      Pattern  : Recursion

      Approach :
      Recursive Insertion

      Idea :
      - If the stack is empty,
        push the given element.
      - Otherwise, pop the top element.
      - Recursively insert the given
        element into the bottom.
      - Push back all the removed
        elements while returning from
        recursion.
      - This preserves the original
        order of the stack above the
        inserted element.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public Stack<Integer> insertAtBottom(Stack<Integer> st,
                                         int x) {

        // Base Case
        if (st.isEmpty()) {

            st.push(x);

            return st;
        }

        // Remove Top Element
        int top = st.pop();

        // Insert at Bottom
        insertAtBottom(st, x);

        // Restore Removed Element
        st.push(top);

        return st;
    }

    public static void main(String[] args) {

        InsertAtBottomOfStackUsingRecursion obj =
                new InsertAtBottomOfStackUsingRecursion();

        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Original Stack : " + st);

        obj.insertAtBottom(st, 5);

        System.out.println("Updated Stack  : " + st);
    }
}
