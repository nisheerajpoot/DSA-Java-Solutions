package backtrack;

public class CountNumbersWithUniqueDigits {

    /*
      Platform : LeetCode

      Question : Count Numbers with
                 Unique Digits

      Pattern  : Backtracking

      Approach :
      Generate Numbers Using
      Backtracking

      Idea :
      - Start building numbers
        digit by digit.
      - Use a visited array to
        ensure every digit is
        used only once.
      - Skip leading zero while
        choosing the first digit.
      - Every newly formed valid
        number increases the count.
      - Continue recursively until
        the required length is
        reached.
      - Count also includes the
        number 0.

      Time Complexity :
      O(10!)

      Space Complexity :
      O(n + 10)

      (Recursive Call Stack +
       Visited Array)
    */

    int count = 1;   // Count includes 0

    public int countNumbersWithUniqueDigits(int n) {

        // Only Number is 0
        if (n == 0) {
            return 1;
        }

        boolean[] visited =
                new boolean[10];

        backtrack(0,
                  n,
                  visited);

        return count;
    }

    private void backtrack(int length,
                           int maxLength,
                           boolean[] visited) {

        // Maximum Length Reached
        if (length == maxLength) {
            return;
        }

        for (int digit = 0;
             digit <= 9;
             digit++) {

            // Skip Leading Zero
            if (length == 0 &&
                digit == 0) {
                continue;
            }

            // Digit Already Used
            if (visited[digit]) {
                continue;
            }

            visited[digit] = true;

            count++;

            backtrack(length + 1,
                      maxLength,
                      visited);

            // Backtrack
            visited[digit] = false;
        }
    }

    public static void main(String[] args) {

        CountNumbersWithUniqueDigits obj =
                new CountNumbersWithUniqueDigits();

        int n = 2;

        int result =
                obj.countNumbersWithUniqueDigits(n);

        System.out.println(
                "Count of Numbers with Unique Digits : "
                        + result);
    }
}