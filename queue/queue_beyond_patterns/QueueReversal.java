package queue.queue_beyond_patterns;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    /*
      Platform : GFG
      Question : Queue Reversal


      Approach :
      Stack + Queue

      Idea :
      - Push all queue elements into stack.
      - Pop elements from stack and insert back into queue.
      - Stack reverses the order because of LIFO.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)
    */

    public void reverseQueue(Queue<Integer> q) {

        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.offer(s.pop());
        }
    }

    public static void main(String[] args) {

        QueueReversal obj = new QueueReversal();

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);

        System.out.println("Before: " + q);

        obj.reverseQueue(q);

        System.out.println("After : " + q);
    }
}