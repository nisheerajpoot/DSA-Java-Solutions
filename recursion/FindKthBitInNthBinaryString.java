package recursion;

import java.util.Scanner;

public class FindKthBitInNthBinaryString {

    /*
      Platform : LeetCode

      Question : Find Kth Bit in Nth Binary String

      Pattern  : Recursion

      Approach :
      Divide and Conquer

      Idea :
      - Every binary string Sn is built as:
          Sn = S(n-1) + "1" + reverse(invert(S(n-1)))
      - Find the middle position.
      - If k is at the middle,
        return '1'.
      - If k lies in the left half,
        recursively search in S(n-1).
      - If k lies in the right half:
          • Find its mirror position.
          • Recursively search the mirror.
          • Invert the returned bit.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public char findKthBit(int n, int k) {

        // Base Case
        if (n == 1) {
            return '0';
        }

        // Length of current string
        int len = (1 << n) - 1;

        // Middle position
        int mid = (len + 1) / 2;

        // Middle bit is always 1
        if (k == mid) {
            return '1';
        }

        // Left Half
        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        // Mirror Position
        int mirror = len - k + 1;

        // Recursive Call
        char bit = findKthBit(n - 1, mirror);

        // Invert the Bit
        return bit == '0' ? '1' : '0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        FindKthBitInNthBinaryString obj =
                new FindKthBitInNthBinaryString();

        System.out.println(obj.findKthBit(n, k));

        sc.close();
    }
}