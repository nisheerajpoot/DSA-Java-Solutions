package queue.basic_queue_simulation;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {

    /*
      Platform : LeetCode
      Question : Number of Recent Calls
      Pattern  : Queue Simulation

      Time Complexity :
      ping() -> O(1) Amortized

      Space Complexity :
      O(n)
    */

    Queue<Integer> queue;

    public NumberOfRecentCalls() {

        queue = new LinkedList<>();
    }

    public int ping(int t) {

        queue.offer(t);

        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {

        NumberOfRecentCalls obj = new NumberOfRecentCalls();

        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
}