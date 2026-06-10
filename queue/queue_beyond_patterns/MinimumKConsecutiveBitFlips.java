package queue.queue_beyond_patterns;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumKConsecutiveBitFlips {

    /*
      Platform : LeetCode
      Question : Minimum Number of K Consecutive Bit Flips
      Pattern  : Queue Beyond Patterns

      Approach :
      Sliding Window + Deque

      Idea :
      - Store starting indices of active flips in deque.
      - Remove flips that are no longer affecting current index.
      - If number of active flips is odd, current bit is inverted.
      - If current bit becomes 0, start a new flip from here.
      - If k elements are not available, return -1.

      Time Complexity :
      O(n)

      Space Complexity :
      O(k)
    */

    public int kBitFlips(int[] arr, int k) {

        Deque<Integer> dq = new ArrayDeque<>();

        int flips = 0;

        for (int i = 0; i < arr.length; i++) {

            while (!dq.isEmpty() && dq.peekFirst() + k <= i) {
                dq.pollFirst();
            }

            int currentBit = arr[i];

            if (dq.size() % 2 == 1) {
                currentBit = 1 - currentBit;
            }

            if (currentBit == 0) {

                if (i + k > arr.length) {
                    return -1;
                }

                dq.offerLast(i);
                flips++;
            }
        }

        return flips;
    }

    public static void main(String[] args) {

        MinimumKConsecutiveBitFlips obj =
                new MinimumKConsecutiveBitFlips();

        int[] arr = {0, 1, 0};

        int k = 1;

        System.out.println(obj.kBitFlips(arr, k));
    }
}