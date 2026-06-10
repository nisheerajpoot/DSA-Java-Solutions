package stack.two_stack_design_pattern;

import java.util.Scanner;
import java.util.Stack;

public class MinStack {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MinStack() {

        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int val) {

        st1.push(val);

        if (st2.isEmpty() || val <= st2.peek()) {
            st2.push(val);
        }
    }

    public void pop() {

        if (st1.peek().equals(st2.peek())) {
            st2.pop();
        }

        st1.pop();
    }

    public int top() {

        return st1.peek();
    }

    public int getMin() {

        return st2.peek();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MinStack obj = new MinStack();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {

            int val = sc.nextInt();

            obj.push(val);
        }

        System.out.println("Top element: " + obj.top());

        System.out.println("Minimum element: " + obj.getMin());

        obj.pop();

        System.out.println("Top after pop: " + obj.top());

        System.out.println("Minimum after pop: " + obj.getMin());

        sc.close();
    }
}