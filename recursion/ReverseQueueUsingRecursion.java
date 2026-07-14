package recursion;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Reverse a Queue

      Pattern  : Recursion

      Approach :
      Recursive Reversal

      Idea :
      - Remove the front element
        from the queue.
      - Recursively reverse the
        remaining queue.
      - Insert the removed element
        at the rear while returning
        from recursion.
      - Continue until the queue
        becomes empty.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public void reverseQueue(Queue<Integer> q) {

        // Base Case
        if (q.isEmpty()) {
            return;
        }

        // Remove Front Element
        int front = q.poll();

        // Reverse Remaining Queue
        reverseQueue(q);

        // Insert at Rear
        q.offer(front);
    }

    public static void main(String[] args) {

        ReverseQueueUsingRecursion obj =
                new ReverseQueueUsingRecursion();

        Queue<Integer> q = new LinkedList<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);

        System.out.println("Original Queue : " + q);

        obj.reverseQueue(q);

        System.out.println("Reversed Queue : " + q);
    }
}
