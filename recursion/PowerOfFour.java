package recursion;

import java.util.Scanner;

public class PowerOfFour {

    /*
      Platform : LeetCode

      Question : Power of Four

      Pattern  : Recursion

      Approach :
      Recursive Division

      Idea :
      - A power of 4 can be repeatedly
        divided by 4 until it becomes 1.
      - If the number becomes 1,
        it is a power of 4.
      - If the number is less than or
        equal to 0, or not divisible by 4,
        it is not a power of 4.

      Time Complexity :
      O(log₄ n)

      Space Complexity :
      O(log₄ n)

      (Recursive Call Stack)
    */

    public boolean isPowerOfFour(int n) {

        // Base Case
        if (n == 1) {
            return true;
        }

        // Invalid Case
        if (n <= 0 || n % 4 != 0) {
            return false;
        }

        // Recursive Call
        return isPowerOfFour(n / 4);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PowerOfFour obj = new PowerOfFour();

        System.out.println(obj.isPowerOfFour(n));

        sc.close();
    }
}