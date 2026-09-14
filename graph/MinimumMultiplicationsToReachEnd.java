package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {

    /*
      Platform : GeeksforGeeks

      Question : Minimum Multiplications to Reach End

      Pattern  : Shortest Path

      Approach : BFS

      Idea :
      - Har number ko graph ka node maan sakte hain.
      - Current number ko array ke har number
        se multiply karenge.
      - Next state:
            (current * num) % 1000
      - Har multiplication ka cost = 1 step.
      - Isliye BFS use karenge.
      - Queue mein current number store karenge.
      - Visited array duplicate states ko
        dobara process hone se rokta hai.
      - Destination milte hi minimum steps return karenge.
      - Agar destination unreachable hai,
        return -1.

      Important :
      - Values modulo 1000 ke andar rahengi.
      - long use kiya gaya hai multiplication overflow
        avoid karne ke liye.

      Time Complexity :
      O(1000 * N)

      Space Complexity :
      O(1000)

      Where :
      N = arr.length
    */

    public int minSteps(
            int[] arr,
            int start,
            int end) {

        // Start and end are same
        if (start == end) {

            return 0;
        }

        // Visited array
        boolean[] visited =
                new boolean[1000];

        // BFS Queue
        Queue<Integer> q =
                new ArrayDeque<>();

        q.offer(start);

        visited[start] = true;

        int steps = 0;

        // BFS
        while (!q.isEmpty()) {

            int size =
                    q.size();

            steps++;

            while (size-- > 0) {

                int current =
                        q.poll();

                // Try every multiplication
                for (int num : arr) {

                    int next =
                            (int) (
                                ((long) current * num)
                                % 1000
                            );

                    // Destination reached
                    if (next == end) {

                        return steps;
                    }

                    // Visit new state
                    if (!visited[next]) {

                        visited[next] = true;

                        q.offer(next);
                    }
                }
            }
        }

        // Destination unreachable
        return -1;
    }

    public static void main(String[] args) {

        MinimumMultiplicationsToReachEnd obj =
                new MinimumMultiplicationsToReachEnd();

        int[] arr = {
                3, 4, 65
        };

        int start = 7;

        int end = 175;

        int result =
                obj.minSteps(
                        arr,
                        start,
                        end);

        System.out.println(
                "Minimum Steps : "
                        + result);
    }
}