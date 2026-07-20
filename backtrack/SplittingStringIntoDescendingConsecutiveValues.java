package backtrack;

public class SplittingStringIntoDescendingConsecutiveValues {

    /*
      Platform : LeetCode

      Question : Splitting a String Into Descending
                 Consecutive Values

      Pattern  : Backtracking

      Approach :
      Partition Based Backtracking

      Idea :
      - Choose the first number by
        taking different prefixes
        of the string.
      - Recursively build the next
        number from the remaining
        characters.
      - The next number must be
        exactly one less than the
        previous number.
      - If such a number is found,
        continue recursively.
      - If all characters are used,
        a valid split is found.

      Time Complexity :
      O(2ⁿ)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public boolean splitString(String s) {

        long first = 0;

        // Try Every Possible First Number
        for (int i = 0; i < s.length() - 1; i++) {

            first = first * 10 + (s.charAt(i) - '0');

            if (backtrack(i + 1, first, s)) {
                return true;
            }
        }

        return false;
    }

    private boolean backtrack(int index,
                              long previous,
                              String s) {

        // Base Case
        if (index == s.length()) {
            return true;
        }

        long current = 0;

        // Try Every Possible Next Number
        for (int i = index; i < s.length(); i++) {

            current = current * 10 + (s.charAt(i) - '0');

            // Valid Choice
            if (current == previous - 1) {

                if (backtrack(i + 1,
                              current,
                              s)) {
                    return true;
                }
            }

            // No Need to Continue
            if (current >= previous) {
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        SplittingStringIntoDescendingConsecutiveValues obj =
                new SplittingStringIntoDescendingConsecutiveValues();

        String s = "050043";

        boolean result = obj.splitString(s);

        System.out.println("Can Split : " + result);
    }
}