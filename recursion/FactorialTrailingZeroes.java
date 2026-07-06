package recursion;

import java.util.Scanner;

public class FactorialTrailingZeroes {

    /*
      Platform : LeetCode

      Question : Factorial Trailing Zeroes

      Pattern  : Recursion

      Approach :
      Recursive Division by 5

      Idea :
      - A trailing zero is formed by
        the pair (2 × 5).
      - Since there are always more
        factors of 2 than 5 in n!,
        we only count the factors of 5.
      - Count multiples of 5,
        then multiples of 25,
        then multiples of 125,
        and so on.
      - Recursively divide n by 5
        until it becomes 0.

      Time Complexity :
      O(log₅ n)

      Space Complexity :
      O(log₅ n)

      (Recursive Call Stack)
    */

    public int trailingZeroes(int n) {

        // Base Case
        if (n == 0) {
            return 0;
        }

        // Recursive Call
        return (n / 5) + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        FactorialTrailingZeroes obj =
                new FactorialTrailingZeroes();

        System.out.println(obj.trailingZeroes(n));

        sc.close();
    }
}