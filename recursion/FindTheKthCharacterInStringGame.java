package recursion;

import java.util.Scanner;

public class FindTheKthCharacterInStringGame {

    /*
      Platform : LeetCode

      Question : Find the K-th Character in String Game

      Pattern  : Recursion

      Approach :
      Divide and Conquer

      Idea :
      - The string length doubles after
        every operation.
      - Find the smallest power of 2
        whose length is at least k.
      - Divide the current string into:
          • Left Half
          • Right Half
      - If k lies in the left half,
        recursively search there.
      - If k lies in the right half:
          • Convert k to its corresponding
            position in the left half.
          • Recursively find the character.
          • Increment the returned
            character by one.

      Time Complexity :
      O(log k)

      Space Complexity :
      O(log k)

      (Recursive Call Stack)
    */

    public char kthCharacter(int k) {

        int len = 1;

        while (len < k) {
            len *= 2;
        }

        return solve(k, len);
    }

    private char solve(int k, int len) {

        // Base Case
        if (len == 1) {
            return 'a';
        }

        int half = len / 2;

        // Left Half
        if (k <= half) {
            return solve(k, half);
        }

        // Right Half
        char ch = solve(k - half, half);

        return (char) (ch + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        FindTheKthCharacterInStringGame obj =
                new FindTheKthCharacterInStringGame();

        System.out.println(obj.kthCharacter(k));

        sc.close();
    }
}