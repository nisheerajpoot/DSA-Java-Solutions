package stack.two_stack_design_pattern;

import java.util.Scanner;
import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public ImplementQueueUsingStacks() {

        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {

        st1.push(x);
    }

    public int pop() {

        if (st2.isEmpty()) {

            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }

        return st2.pop();
    }

    public int peek() {

        if (st2.isEmpty()) {

            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }

        return st2.peek();
    }

    public boolean empty() {

        return st1.isEmpty() && st2.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ImplementQueueUsingStacks obj =
                new ImplementQueueUsingStacks();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter queue elements:");

        for (int i = 0; i < n; i++) {

            int val = sc.nextInt();

            obj.push(val);
        }

        System.out.println("Front element: " + obj.peek());

        System.out.println("Removed element: " + obj.pop());

        System.out.println("Front after pop: " + obj.peek());

        System.out.println("Is queue empty? " + obj.empty());

        sc.close();
    }
}