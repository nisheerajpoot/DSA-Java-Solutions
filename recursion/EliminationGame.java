package recursion;

import java.util.Scanner;

public class EliminationGame {

    /*
      Platform : LeetCode

      Question : Elimination Game

      Pattern  : Recursion

      Approach :
      Mathematical Recursion

      Idea :
      - Numbers are removed alternately
        from left to right and then
        from right to left.
      - After the first elimination,
        only even numbers remain.
      - Divide the problem into a
        smaller subproblem of size n / 2.
      - Recursively find the last
        remaining number in the
        reduced list.
      - Convert the answer back to the
        original numbering using the
        mathematical relation.

      Time Complexity :
      O(log n)

      Space Complexity :
      O(log n)

      (Recursive Call Stack)
    */

    public int lastRemaining(int n) {

        // Base Case
        if (n == 1) {
            return 1;
        }

        // Recursive Formula
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        EliminationGame obj = new EliminationGame();

        System.out.println(obj.lastRemaining(n));

        sc.close();
    }
}