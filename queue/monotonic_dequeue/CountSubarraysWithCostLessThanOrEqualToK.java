package queue.monotonic_dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountSubarraysWithCostLessThanOrEqualToK {

    public static long countSubarrays(int[] nums, long k) {

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {

            while (!maxDeque.isEmpty() &&
                    nums[right] > nums[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }

            while (!minDeque.isEmpty() &&
                    nums[right] < nums[minDeque.peekLast()]) {
                minDeque.pollLast();
            }

            maxDeque.offerLast(right);
            minDeque.offerLast(right);

            while (left <= right &&
                    ((long) (nums[maxDeque.peekFirst()] -
                             nums[minDeque.peekFirst()]) *
                            (right - left + 1)) > k) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 2};
        long k = 4;

        long result = countSubarrays(nums, k);

        System.out.println(result);
    }
}