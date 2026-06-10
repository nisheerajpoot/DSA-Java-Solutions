package queue.monotonic_dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ContinuousSubarrays {

    public static long continuousSubarrays(int[] nums) {

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {

            while (!maxDeque.isEmpty() &&
                    nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }

            while (!minDeque.isEmpty() &&
                    nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }

            maxDeque.offerLast(nums[right]);
            minDeque.offerLast(nums[right]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > 2) {

                if (nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }

                if (nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }

                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {5, 4, 2, 4};

        long result = continuousSubarrays(nums);

        System.out.println(result);
    }
}