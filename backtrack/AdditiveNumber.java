package backtrack;

public class AdditiveNumber {

    /*
      Platform : LeetCode

      Question : Additive Number

      Pattern  : Backtracking

      Approach :
      Choose First Two Numbers +
      Backtracking

      Idea :
      - Try every possible first
        number.
      - Try every possible second
        number.
      - Ignore numbers having
        leading zeros (except "0").
      - The next number must be
        equal to the sum of the
        previous two numbers.
      - If the remaining string
        starts with the expected
        sum, continue recursively.
      - If the entire string is
        consumed successfully,
        an additive sequence
        exists.

      Time Complexity :
      O(n³)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public boolean isAdditiveNumber(String num) {

        int n = num.length();

        // Choose First Number
        for (int i = 1; i <= n / 2; i++) {

            // Leading Zero Check
            if (num.charAt(0) == '0' &&
                i > 1) {
                break;
            }

            long first =
                    Long.parseLong(num.substring(0, i));

            // Choose Second Number
            for (int j = 1;
                 Math.max(i, j) <= n - i - j;
                 j++) {

                // Leading Zero Check
                if (num.charAt(i) == '0' &&
                    j > 1) {
                    break;
                }

                long second =
                        Long.parseLong(
                                num.substring(i, i + j));

                if (backtrack(first,
                              second,
                              i + j,
                              num)) {

                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(long first,
                              long second,
                              int index,
                              String num) {

        // Entire String Is Used
        if (index == num.length()) {
            return true;
        }

        long sum = first + second;

        String next = String.valueOf(sum);

        // Expected Sum Must Match
        if (!num.startsWith(next, index)) {
            return false;
        }

        // Continue Recursively
        return backtrack(second,
                         sum,
                         index + next.length(),
                         num);
    }

    public static void main(String[] args) {

        AdditiveNumber obj =
                new AdditiveNumber();

        String num = "112358";

        boolean result =
                obj.isAdditiveNumber(num);

        System.out.println(
                "Is Additive Number : " + result);
    }
}