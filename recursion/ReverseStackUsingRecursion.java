package recursion;


import java.util.Stack;

public class ReverseStackUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Reverse a Stack

      Pattern  : Recursion

      Approach :
      Recursive Reversal

      Idea :
      - Pop the top element from the stack.
      - Recursively reverse the remaining stack.
      - Insert the removed element at the
        bottom of the reversed stack using
        recursion.
      - Repeat until the entire stack is
        reversed.

      Time Complexity :
      O(n²)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public static void reverseStack(Stack<Integer> stack) {

        // Base Case
        if (stack.isEmpty()) {
            return;
        }

        // Remove Top Element
        int top = stack.pop();

        // Reverse Remaining Stack
        reverseStack(stack);

        // Insert at Bottom
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack,
                                       int value) {

        // Base Case
        if (stack.isEmpty()) {

            stack.push(value);

            return;
        }

        int top = stack.pop();

        insertAtBottom(stack, value);

        stack.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Original Stack : " + stack);

        reverseStack(stack);

        System.out.println("Reversed Stack : " + stack);
    }
}