package recursion;

import java.util.Scanner;

public class PrintNumbersFrom1ToN {

    /*
      Platform : GeeksforGeeks

      Question : Print 1 to N Without Loop

      Pattern  : Recursion

      Approach :
      Recursive Printing

      Idea :
      - If n becomes less than 1,
        stop the recursion.
      - First, recursively call for (n - 1).
      - Print the current number while
        returning from recursion.
      - This prints the numbers in
        increasing order.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public void printTillN(int n) {

        // Base Case
        if (n < 1) {
            return;
        }

        // Recursive Call
        printTillN(n - 1);

        // Print while backtracking
        System.out.print(n + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PrintNumbersFrom1ToN obj = new PrintNumbersFrom1ToN();

        obj.printTillN(n);

        sc.close();
    }
}