package recursion;

import java.util.Stack;

public class SortStackUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Sort a Stack

      Pattern  : Recursion

      Approach :
      Recursive Sorting

      Idea :
      - Pop the top element from the stack.
      - Recursively sort the remaining stack.
      - Insert the popped element back into
        its correct sorted position using
        recursion.
      - Repeat until all elements are placed
        in sorted order.

      Time Complexity :
      O(n²)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public void sortStack(Stack<Integer> stack) {

        // Base Case
        if (stack.isEmpty()) {
            return;
        }

        // Remove Top Element
        int top = stack.pop();

        // Sort Remaining Stack
        sortStack(stack);

        // Insert in Sorted Position
        sortedInsert(stack, top);
    }

    private void sortedInsert(Stack<Integer> stack,
                              int value) {

        // Correct Position Found
        if (stack.isEmpty() || stack.peek() <= value) {

            stack.push(value);

            return;
        }

        int top = stack.pop();

        sortedInsert(stack, value);

        stack.push(top);
    }

    public static void main(String[] args) {

        SortStackUsingRecursion obj =
                new SortStackUsingRecursion();

        Stack<Integer> stack = new Stack<>();

        stack.push(30);
        stack.push(10);
        stack.push(40);
        stack.push(20);

        System.out.println("Original Stack : " + stack);

        obj.sortStack(stack);

        System.out.println("Sorted Stack   : " + stack);
    }
}