package recursion;

import java.util.Scanner;

public class PrintNumbersFromNTo1 {

    /*
      Platform : GeeksforGeeks

      Question : Print N to 1 Without Loop

      Pattern  : Recursion

      Approach :
      Recursive Printing

      Idea :
      - If n becomes less than 1,
        stop the recursion.
      - Print the current number.
      - Recursively call for (n - 1).
      - This prints the numbers in
        decreasing order.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public void printNos(int n) {

        // Base Case
        if (n < 1) {
            return;
        }

        // Print Current Number
        System.out.print(n + " ");

        // Recursive Call
        printNos(n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PrintNumbersFromNTo1 obj = new PrintNumbersFromNTo1();

        obj.printNos(n);

        sc.close();
    }
}