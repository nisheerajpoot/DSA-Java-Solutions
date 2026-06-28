package recursion;

import java.util.Scanner;

public class SumOfFirstNNumbers {

    /*
      Platform : GeeksforGeeks

      Question : Sum of First N Numbers

      Pattern  : Recursion

      Approach :
      Recursive Sum

      Idea :
      - If n is 0 or 1, return n.
      - Otherwise, recursively calculate the
        sum of the first (n-1) numbers.
      - Add the current number (n) to the
        recursive result.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public static int sumOf(int n) {

        // Base Case
        if (n <= 1) {
            return n;
        }

        // Recursive Relation
        return sumOf(n - 1) + n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sumOf(n));

        sc.close();
    }
}