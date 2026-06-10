package queue.queue_beyond_patterns;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfAQueue {

    /*
      Platform : GFG
      Question : Reverse First K Elements of Queue
  
      Approach :
      Stack + Queue

      Idea :
      - Remove first k elements and push into stack.
      - Pop from stack and add back to queue.
      - Reverse remaining elements' positions by rotating queue.

      Time Complexity :
      O(n)

      Space Complexity :
      O(k)
    */

    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {

        if (k > q.size() || k <= 0) {
            return q;
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < k; i++) {
            st.push(q.poll());
        }

        while (!st.isEmpty()) {
            q.offer(st.pop());
        }

        int remaining = q.size() - k;

        for (int i = 0; i < remaining; i++) {
            q.offer(q.poll());
        }

        return q;
    }

    public static void main(String[] args) {

        ReverseFirstKElementsOfAQueue obj =
                new ReverseFirstKElementsOfAQueue();

        Queue<Integer> q = new LinkedList<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);

        int k = 3;

        System.out.println("Before: " + q);

        obj.reverseFirstK(q, k);

        System.out.println("After : " + q);
    }
}