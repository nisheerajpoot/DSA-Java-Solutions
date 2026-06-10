package queue.basic_queue_simulation;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets {

    /*
      Platform : LeetCode
      Question : Time Needed to Buy Tickets
      Pattern  : Queue Simulation

      Time Complexity  : O(total tickets)
      Space Complexity : O(n)
    */

    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            q.offer(i);
        }

        int time = 0;

        while (!q.isEmpty()) {

            int idx = q.poll();

            tickets[idx]--;
            time++;

            if (tickets[idx] == 0) {

                if (idx == k) {
                    return time;
                }
            }
            else {

                q.offer(idx);
            }
        }

        return time;
    }

    public static void main(String[] args) {

        TimeNeededToBuyTickets obj =
                new TimeNeededToBuyTickets();

        int[] tickets = {2, 3, 2};

        int k = 2;

        System.out.println(obj.timeRequiredToBuy(tickets, k));
    }
}