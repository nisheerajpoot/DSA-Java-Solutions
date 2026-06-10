package stack.two_stack_design_pattern;

import java.util.Scanner;
import java.util.Stack;

public class DesignATextEditor {

    Stack<Character> left;
    Stack<Character> right;

    public DesignATextEditor() {

        left = new Stack<>();
        right = new Stack<>();
    }

    public void addText(String text) {

        for (char ch : text.toCharArray()) {
            left.push(ch);
        }
    }

    public int deleteText(int k) {

        int count = 0;

        while (k > 0 && !left.isEmpty()) {

            left.pop();

            count++;

            k--;
        }

        return count;
    }

    public String cursorLeft(int k) {

        while (k > 0 && !left.isEmpty()) {

            right.push(left.pop());

            k--;
        }

        return getLast10();
    }

    public String cursorRight(int k) {

        while (k > 0 && !right.isEmpty()) {

            left.push(right.pop());

            k--;
        }

        return getLast10();
    }

    private String getLast10() {

        StringBuilder sb = new StringBuilder();

        int start = Math.max(0, left.size() - 10);

        for (int i = start; i < left.size(); i++) {
            sb.append(left.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DesignATextEditor obj = new DesignATextEditor();

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        obj.addText(text);

        System.out.print("Enter number of characters to delete: ");
        int del = sc.nextInt();

        int deleted = obj.deleteText(del);

        System.out.println("Deleted characters: " + deleted);

        System.out.print("Enter steps to move cursor left: ");
        int leftStep = sc.nextInt();

        String leftAns = obj.cursorLeft(leftStep);

        System.out.println(leftAns);

        System.out.print("Enter steps to move cursor right: ");
        int rightStep = sc.nextInt();

        String rightAns = obj.cursorRight(rightStep);

        System.out.println(rightAns);

        sc.close();
    }
}