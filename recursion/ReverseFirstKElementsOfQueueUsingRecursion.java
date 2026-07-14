package recursion;


import java.util.LinkedList;
import java.util.Queue;

public class ReverseFirstKElementsOfQueueUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Reverse First K Elements of Queue

      Pattern  : Recursion

      Approach :
      Recursive Reversal

      Idea :
      - Remove the first k elements
        recursively from the queue.
      - While returning from recursion,
        insert the removed elements
        back into the queue.
      - Finally, move the remaining
        (n - k) elements from the front
        to the rear to restore their
        original order.

      Time Complexity :
      O(n)

      Space Complexity :
      O(k)

      (Recursive Call Stack)
    */

    public Queue<Integer> reverseFirstK(Queue<Integer> q,
                                        int k) {

        // Base Case
        if (q == null || q.isEmpty()
                || k <= 0 || k > q.size()) {
            return q;
        }

        int n = q.size();

        // Reverse First K Elements
        reverse(q, k);

        // Restore Remaining Elements
        for (int i = 0; i < n - k; i++) {
            q.offer(q.poll());
        }

        return q;
    }

    private void reverse(Queue<Integer> q,
                         int k) {

        // Base Case
        if (k == 0) {
            return;
        }

        int front = q.poll();

        reverse(q, k - 1);

        q.offer(front);
    }

    public static void main(String[] args) {

        ReverseFirstKElementsOfQueueUsingRecursion obj =
                new ReverseFirstKElementsOfQueueUsingRecursion();

        Queue<Integer> q = new LinkedList<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);

        System.out.println("Original Queue : " + q);

        obj.reverseFirstK(q, 3);

        System.out.println("Updated Queue  : " + q);
    }
}