package recursion;

import java.util.Scanner;

public class PowerOfThree {

    /*
      Platform : GeeksforGeeks

      Question : Power of 3

      Pattern  : Recursion

      Approach :
      Recursive Division

      Idea :
      - If the number becomes 1,
        it is a power of 3.
      - If the number is less than or equal
        to 0 or is not divisible by 3,
        it is not a power of 3.
      - Otherwise, recursively divide the
        number by 3 until reaching the base case.

      Time Complexity :
      O(log₃n)

      Space Complexity :
      O(log₃n)

      (Recursive Call Stack)
    */

    public static boolean isPowerOf3(int n) {

        // Base Case : Power of 3
        if (n == 1) {
            return true;
        }

        // Base Case : Not a Power of 3
        if (n <= 0 || n % 3 != 0) {
            return false;
        }

        // Recursive Relation
        return isPowerOf3(n / 3);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isPowerOf3(n));

        sc.close();
    }
}