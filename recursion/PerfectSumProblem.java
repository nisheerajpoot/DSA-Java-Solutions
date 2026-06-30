package recursion;

import java.util.Scanner;

public class PerfectSumProblem {

    /*
      Platform : GeeksforGeeks

      Question : Perfect Sum Problem

      Pattern  : Recursion + Backtracking

      Approach :
      Include / Exclude

      Idea :
      - For every element, there are
        two choices:
          1. Include the current element
             in the subset.
          2. Exclude the current element.
      - When all elements have been
        processed, check whether the
        remaining target is 0.
      - If yes, one valid subset is found.
      - Count all such valid subsets.

      Time Complexity :
      O(2^n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public int perfectSum(int[] nums, int target) {

        return solve(nums, 0, target);
    }

    private int solve(int[] nums, int index, int target) {

        // Base Case
        if (index == nums.length) {

            if (target == 0) {
                return 1;
            }

            return 0;
        }

        // Include Current Element
        int take = solve(nums, index + 1, target - nums[index]);

        // Exclude Current Element
        int notTake = solve(nums, index + 1, target);

        // Total Valid Subsets
        return take + notTake;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        PerfectSumProblem obj = new PerfectSumProblem();

        System.out.println(obj.perfectSum(nums, target));

        sc.close();
    }
}