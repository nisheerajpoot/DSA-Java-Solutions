package queue.basic_queue_simulation;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveTheFirstHalfOfTheQueueWithTheSecondHalf {

    /*
      Platform : GFG
      Question : Interleave the First Half of the Queue with Second Half
     

      Approach :
      Queue Simulation

      Idea :
      - Store first half elements in another queue.
      - Then alternately insert:
        first half element
        second half element

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)
    */

    public void rearrangeQueue(Queue<Integer> q) {

        Queue<Integer> firstHalf = new LinkedList<>();

        int size = q.size();

        for (int i = 0; i < size / 2; i++) {
            firstHalf.offer(q.remove());
        }

        while (!firstHalf.isEmpty()) {

            q.offer(firstHalf.remove());

            q.offer(q.remove());
        }
    }

    public static void main(String[] args) {

        InterleaveTheFirstHalfOfTheQueueWithTheSecondHalf obj =
                new InterleaveTheFirstHalfOfTheQueueWithTheSecondHalf();

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);

        System.out.println("Before: " + q);

        obj.rearrangeQueue(q);

        System.out.println("After : " + q);
    }
}