package recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class RotateDequeUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Rotate Deque By K

      Pattern  : Recursion

      Approach :
      Recursive Rotation

      Idea :
      - If the deque is empty or
        k becomes zero, stop recursion.
      - Reduce k using modulo
        to avoid unnecessary rotations.
      - For right rotation,
        remove the last element and
        insert it at the front.
      - For left rotation,
        remove the first element and
        insert it at the rear.
      - Repeat recursively until
        all rotations are completed.

      Time Complexity :
      O(k)

      Space Complexity :
      O(k)

      (Recursive Call Stack)
    */

    public static void rotateDeque(Deque<Integer> dq,
                                   int type,
                                   int k) {

        // Base Case
        if (dq == null || dq.isEmpty()) {
            return;
        }

        k %= dq.size();

        if (k == 0) {
            return;
        }

        // Right Rotation
        if (type == 1) {
            rotateRight(dq, k);
        }

        // Left Rotation
        else {
            rotateLeft(dq, k);
        }
    }

    private static void rotateRight(Deque<Integer> dq,
                                    int k) {

        // Base Case
        if (k == 0) {
            return;
        }

        int last = dq.pollLast();

        dq.offerFirst(last);

        rotateRight(dq, k - 1);
    }

    private static void rotateLeft(Deque<Integer> dq,
                                   int k) {

        // Base Case
        if (k == 0) {
            return;
        }

        int first = dq.pollFirst();

        dq.offerLast(first);

        rotateLeft(dq, k - 1);
    }

    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>();

        dq.offerLast(1);
        dq.offerLast(2);
        dq.offerLast(3);
        dq.offerLast(4);
        dq.offerLast(5);

        System.out.println("Original Deque : " + dq);

        rotateDeque(dq, 1, 2);

        System.out.println("Right Rotate   : " + dq);

        rotateDeque(dq, 2, 2);

        System.out.println("Left Rotate    : " + dq);
    }
}