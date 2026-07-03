package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /*
      Platform : LeetCode

      Question : Find First and Last Position of Element in Sorted Array

      Pattern  : Recursion + Binary Search

      Approach :
      Recursive Binary Search

      Idea :
      - Perform Binary Search twice.
      - First search finds the leftmost
        occurrence of the target.
      - Second search finds the rightmost
        occurrence of the target.
      - Whenever the target is found:
          • Store the current index.
          • Continue searching on the
            required side.
      - Return both indices.

      Time Complexity :
      O(log n)

      Space Complexity :
      O(log n)

      (Recursive Call Stack)
    */

    public int[] searchRange(int[] nums, int target) {

        int first = firstOccurrence(nums, target,
                0, nums.length - 1, -1);

        int last = lastOccurrence(nums, target,
                0, nums.length - 1, -1);

        return new int[]{first, last};
    }

    private int firstOccurrence(int[] nums,
                                int target,
                                int low,
                                int high,
                                int ans) {

        // Base Case
        if (low > high) {
            return ans;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {

            ans = mid;

            // Search Left Side
            return firstOccurrence(nums,
                    target,
                    low,
                    mid - 1,
                    ans);

        } else if (nums[mid] < target) {

            // Search Right Side
            return firstOccurrence(nums,
                    target,
                    mid + 1,
                    high,
                    ans);

        } else {

            // Search Left Side
            return firstOccurrence(nums,
                    target,
                    low,
                    mid - 1,
                    ans);
        }
    }

    private int lastOccurrence(int[] nums,
                               int target,
                               int low,
                               int high,
                               int ans) {

        // Base Case
        if (low > high) {
            return ans;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {

            ans = mid;

            // Search Right Side
            return lastOccurrence(nums,
                    target,
                    mid + 1,
                    high,
                    ans);

        } else if (nums[mid] < target) {

            // Search Right Side
            return lastOccurrence(nums,
                    target,
                    mid + 1,
                    high,
                    ans);

        } else {

            // Search Left Side
            return lastOccurrence(nums,
                    target,
                    low,
                    mid - 1,
                    ans);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        FindFirstAndLastPositionOfElementInSortedArray obj =
                new FindFirstAndLastPositionOfElementInSortedArray();

        System.out.println(Arrays.toString(obj.searchRange(nums, target)));

        sc.close();
    }
}