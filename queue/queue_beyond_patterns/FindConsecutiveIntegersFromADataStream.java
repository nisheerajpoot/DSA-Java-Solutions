package queue.queue_beyond_patterns;

import java.util.LinkedList;
import java.util.Queue;

public class FindConsecutiveIntegersFromADataStream {

    /*
      Platform : LeetCode
      Question : Find Consecutive Integers from a Data Stream
      Pattern  : Queue Beyond Patterns

      Approach :
      Sliding Window + Queue

      Idea :
      - Maintain a window of size k.
      - Store incoming numbers in queue.
      - Keep count of how many elements equal to value.
      - If window size exceeds k, remove oldest element.
      - Return true only when:
            window size == k
            and all k elements equal value.

      Time Complexity :
      consec() -> O(1)

      Space Complexity :
      O(k)
    */

    Queue<Integer> q;
    int value;
    int k;
    int matchCount;

    public FindConsecutiveIntegersFromADataStream(int value, int k) {

        this.value = value;
        this.k = k;

        q = new LinkedList<>();
        matchCount = 0;
    }

    public boolean consec(int num) {

        q.offer(num);

        if (num == value) {
            matchCount++;
        }

        if (q.size() > k) {

            int removed = q.poll();

            if (removed == value) {
                matchCount--;
            }
        }

        return q.size() == k && matchCount == k;
    }

    public static void main(String[] args) {

        FindConsecutiveIntegersFromADataStream obj =
                new FindConsecutiveIntegersFromADataStream(4, 3);

        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(3));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
    }
}