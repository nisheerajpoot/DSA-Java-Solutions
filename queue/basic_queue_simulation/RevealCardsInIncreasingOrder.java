package queue.basic_queue_simulation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {

    /*
      Platform : LeetCode
      Question : Reveal Cards In Increasing Order

      Approach :
      Queue Simulation

      Idea :
      - Sort the deck.
      - Store all indices (0 to n-1) in a queue.
      - Place the smallest card at the front index.
      - Move the next index to the back of the queue.
      - Repeat until all cards are placed.

      Time Complexity :
      O(n log n)

      Space Complexity :
      O(n)
    */

    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);

        int n = deck.length;

        int[] ans = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(i);
        }

        for (int card : deck) {

            ans[q.poll()] = card;

            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        RevealCardsInIncreasingOrder obj =
                new RevealCardsInIncreasingOrder();

        int[] deck = {17, 13, 11, 2, 3, 5, 7};

        System.out.println(
                Arrays.toString(
                        obj.deckRevealedIncreasing(deck)
                )
        );
    }
}