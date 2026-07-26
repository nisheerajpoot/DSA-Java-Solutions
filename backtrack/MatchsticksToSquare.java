package backtrack;

import java.util.Arrays;

public class MatchsticksToSquare {

    /*
      Platform : LeetCode

      Question : Matchsticks to Square

      Pattern  : Backtracking

      Approach :
      Assign Matchsticks to
      Four Sides

      Idea :
      - Calculate the total length
        of all matchsticks.
      - If the total is not divisible
        by 4, forming a square is
        impossible.
      - Each side must have length
        equal to total / 4.
      - Sort the matchsticks in
        descending order so larger
        sticks are placed first.
      - Try placing the current
        matchstick on each of the
        four sides.
      - If a side exceeds the target
        length, skip it.
      - After recursion, remove the
        matchstick from the side
        (Backtrack).
      - If a matchstick cannot be
        placed on an empty side,
        there is no need to try the
        remaining empty sides.

      Time Complexity :
      O(4ⁿ)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int stick : matchsticks) {
            sum += stick;
        }

        // Square Cannot Be Formed
        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        // Sort in Descending Order
        Arrays.sort(matchsticks);

        reverse(matchsticks);

        int[] sides = new int[4];

        return backtrack(matchsticks,
                         0,
                         sides,
                         target);
    }

    private boolean backtrack(int[] matchsticks,
                              int index,
                              int[] sides,
                              int target) {

        // All Matchsticks Used
        if (index == matchsticks.length) {
            return true;
        }

        int stick = matchsticks[index];

        // Try Every Side
        for (int side = 0;
             side < 4;
             side++) {

            // Side Exceeds Target
            if (sides[side] + stick > target) {
                continue;
            }

            // Place Matchstick
            sides[side] += stick;

            // Explore
            if (backtrack(matchsticks,
                          index + 1,
                          sides,
                          target)) {

                return true;
            }

            // Backtrack
            sides[side] -= stick;

            // Optimization
            if (sides[side] == 0) {
                break;
            }
        }

        return false;
    }

    private void reverse(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        MatchsticksToSquare obj =
                new MatchsticksToSquare();

        int[] matchsticks = {
                1, 1, 2, 2, 2
        };

        boolean result =
                obj.makesquare(matchsticks);

        System.out.println(
                "Can Form Square : " + result);
    }
}