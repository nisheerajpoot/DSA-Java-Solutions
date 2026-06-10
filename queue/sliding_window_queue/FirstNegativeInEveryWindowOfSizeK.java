package queue.sliding_window_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {

    public static List<Integer> firstNegInt(int arr[], int k) {

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int i = 0;
        int j = 0;

        while (j < arr.length) {

            if (arr[j] < 0) {
                q.offer(j);
            }

            if (j - i + 1 < k) {
                j++;
            } else {

                if (q.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(arr[q.peek()]);
                }

                if (!q.isEmpty() && q.peek() == i) {
                    q.poll();
                }

                i++;
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;

        List<Integer> result = firstNegInt(arr, k);

        System.out.println(result);
    }
}