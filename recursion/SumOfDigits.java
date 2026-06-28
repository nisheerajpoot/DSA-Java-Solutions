package recursion;

import java.util.Scanner;

public class SumOfDigits {

    /*
      Platform : GeeksforGeeks

      Question : Sum of Digits

      Pattern  : Recursion

      Approach :
      Recursive Digit Processing

      Idea :
      - If the number is a single digit,
        return the number.
      - Otherwise, take the last digit
        using (n % 10).
      - Recursively calculate the sum of
        the remaining digits (n / 10).
      - Add both results.

      Time Complexity :
      O(d)

      Space Complexity :
      O(d)

      where d = Number of digits
      (Recursive Call Stack)
    */

    public static int sumOfDigits(int n) {

        // Base Case
        if (n <= 9) {
            return n;
        }

        // Recursive Relation
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sumOfDigits(n));

        sc.close();
    }
}