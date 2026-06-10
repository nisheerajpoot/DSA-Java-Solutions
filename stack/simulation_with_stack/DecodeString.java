package stack.simulation_with_stack;

import java.util.Stack;

public class DecodeString {

    /*
      Platform : LeetCode
      Question : Decode String
      Pattern  : Simulation With Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();

        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();

        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {

                num = num * 10 + (ch - '0');
            }
            else if (ch == '[') {

                countStack.push(num);

                stringStack.push(current);

                num = 0;

                current = new StringBuilder();
            }
            else if (ch == ']') {

                int repeat = countStack.pop();

                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++) {

                    prev.append(current);
                }

                current = prev;
            }
            else {

                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {

        DecodeString obj = new DecodeString();

        String s = "3[a2[c]]";

        System.out.println(obj.decodeString(s));
    }
}