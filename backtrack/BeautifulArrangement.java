package backtrack;

public class BeautifulArrangement {

    /*
      Platform : LeetCode

      Question : Beautiful Arrangement

      Pattern  : Backtracking

      Approach :
      Choice Based Backtracking

      Idea :
      - Place numbers from 1 to n
        at each position.
      - A number can be placed only
        if it satisfies:
          1. number % position == 0
          OR
          2. position % number == 0
      - Keep track of used numbers.
      - Recursively fill the next
        position.
      - After recursion, mark the
        number as unused
        (Backtrack).
      - When all positions are filled,
        increase the count.

      Time Complexity :
      O(n!)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    private int count = 0;

    public int countArrangement(int n) {

        boolean[] used = new boolean[n + 1];

        backtrack(1, n, used);

        return count;
    }

    private void backtrack(int position,
                           int n,
                           boolean[] used) {

        // Base Case
        if (position > n) {

            count++;

            return;
        }

        // Try Every Choice
        for (int num = 1; num <= n; num++) {

            if (used[num]) {
                continue;
            }

            // Check Beautiful Arrangement Condition
            if (num % position == 0 ||
                position % num == 0) {

                // Choose
                used[num] = true;

                // Explore
                backtrack(position + 1,
                          n,
                          used);

                // Backtrack
                used[num] = false;
            }
        }
    }

    public static void main(String[] args) {

        BeautifulArrangement obj =
                new BeautifulArrangement();

        int n = 3;

        int result = obj.countArrangement(n);

        System.out.println("Beautiful Arrangements : " + result);
    }
}