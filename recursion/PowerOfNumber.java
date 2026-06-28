package recursion;

import java.util.Scanner;

public class PowerOfNumber {

    /*
      Platform : GeeksforGeeks

      Question : Power of a Number

      Pattern  : Recursion

      Approach :
      Recursive Multiplication

      Idea :
      - If the exponent becomes 0,
        return 1.
      - Otherwise, recursively calculate
        the power with exponent (p - 1).
      - Multiply the result by the base
        number.

      Time Complexity :
      O(p)

      Space Complexity :
      O(p)

      (Recursive Call Stack)
    */

    public static int recursivePower(int n, int p) {

        // Base Case
        if (p == 0) {
            return 1;
        }

        // Recursive Relation
        return recursivePower(n, p - 1) * n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        System.out.println(recursivePower(n, p));

        sc.close();
    }
}