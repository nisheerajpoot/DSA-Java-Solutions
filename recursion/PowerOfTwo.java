package recursion;

import java.util.Scanner;

public class PowerOfTwo {

    /*
      Platform : LeetCode

      Question : Power of Two

      Pattern  : Recursion

      Approach :
      Recursive Division

      Idea :
      - A power of 2 can be repeatedly
        divided by 2 until it becomes 1.
      - If the number becomes 1,
        it is a power of 2.
      - If the number is less than or
        equal to 0, or not divisible by 2,
        it is not a power of 2.

      Time Complexity :
      O(log n)

      Space Complexity :
      O(log n)

      (Recursive Call Stack)
    */

    public boolean isPowerOfTwo(int n) {

        // Base Case
        if (n == 1) {
            return true;
        }

        // Invalid Case
        if (n <= 0 || n % 2 != 0) {
            return false;
        }

        // Recursive Call
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PowerOfTwo obj = new PowerOfTwo();

        System.out.println(obj.isPowerOfTwo(n));

        sc.close();
    }
}