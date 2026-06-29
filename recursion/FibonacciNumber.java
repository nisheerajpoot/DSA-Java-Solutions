package recursion;

import java.util.Scanner;

public class FibonacciNumber {

    /*
      Platform : LeetCode

      Question : Fibonacci Number

      Pattern  : Recursion

      Approach :
      Recursive Fibonacci

      Idea :
      - If n is 0 or 1,
        return n.
      - Otherwise, recursively calculate
        the previous two Fibonacci numbers.
      - Return their sum.

      Time Complexity :
      O(2^n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public int fib(int n) {

        // Base Case
        if (n <= 1) {
            return n;
        }

        // Recursive Relation
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        FibonacciNumber obj = new FibonacciNumber();

        System.out.println(obj.fib(n));

        sc.close();
    }
}