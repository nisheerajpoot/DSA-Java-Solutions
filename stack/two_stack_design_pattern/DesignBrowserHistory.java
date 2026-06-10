package stack.two_stack_design_pattern;

import java.util.Scanner;
import java.util.Stack;

public class DesignBrowserHistory {

    Stack<String> back;
    Stack<String> forward;
    String current;

    public DesignBrowserHistory(String homepage) {

        back = new Stack<>();
        forward = new Stack<>();
        current = homepage;
    }

    public void visit(String url) {

        back.push(current);
        current = url;

        forward.clear();
    }

    public String back(int steps) {

        while (steps > 0 && !back.isEmpty()) {

            forward.push(current);
            current = back.pop();

            steps--;
        }

        return current;
    }

    public String forward(int steps) {

        while (steps > 0 && !forward.isEmpty()) {

            back.push(current);
            current = forward.pop();

            steps--;
        }

        return current;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter homepage: ");
        String homepage = sc.nextLine();

        DesignBrowserHistory obj =
                new DesignBrowserHistory(homepage);

        System.out.print("Enter first website: ");
        String site1 = sc.nextLine();

        obj.visit(site1);

        System.out.print("Enter second website: ");
        String site2 = sc.nextLine();

        obj.visit(site2);

        System.out.print("Enter back steps: ");
        int backStep = sc.nextInt();

        System.out.println(obj.back(backStep));

        System.out.print("Enter forward steps: ");
        int forwardStep = sc.nextInt();

        System.out.println(obj.forward(forwardStep));

        sc.close();
    }
}