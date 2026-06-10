package queue.basic_queue_simulation;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame {

    /*
      Platform : LeetCode
      Question : Find the Winner of the Circular Game
      Pattern  : Queue Simulation

      Approach :
      Circular Queue Simulation

      Idea :
      - Put players 1 to n into a queue.
      - Move first (k - 1) players to the back.
      - Remove the kth player.
      - Repeat until only one player remains.
      - The remaining player is the winner.

      Time Complexity :
      O(n * k)

      Space Complexity :
      O(n)
    */

    public int findTheWinner(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {

            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }

            queue.poll();
        }

        return queue.poll();
    }

    public static void main(String[] args) {

        FindTheWinnerOfTheCircularGame obj =
                new FindTheWinnerOfTheCircularGame();

        int n = 5;
        int k = 2;

        System.out.println("Winner = " +
                obj.findTheWinner(n, k));
    }
}