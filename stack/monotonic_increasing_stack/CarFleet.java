package stack.monotonic_increasing_stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    /*
      Platform : LeetCode
      Question : Car Fleet
      Pattern  : Monotonic Increasing Stack

      Time Complexity  : O(n log n)
      Space Complexity : O(n)
    */

    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> a[0] - b[0]);

        Stack<Double> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            double time =
                (double) (target - cars[i][0]) / cars[i][1];

            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }
        }

        return st.size();
    }

    public static void main(String[] args) {

        CarFleet obj = new CarFleet();

        int target = 12;

        int[] position = {10, 8, 0, 5, 3};

        int[] speed = {2, 4, 1, 1, 3};

        System.out.println(
                obj.carFleet(target, position, speed)
        );
    }
}