package backtrack;

public class TargetSum {

    /*
      Platform : LeetCode

      Question : Target Sum

      Pattern  : Backtracking

      Approach :
      Pick + / Pick -

      Idea :
      - For every number, we have
        exactly two choices:
          1. Add the current number.
          2. Subtract the current number.
      - Recursively process the next
        index with the updated sum.
      - When all numbers are processed,
        check whether the obtained sum
        equals the target.
      - If yes, count it as one valid
        expression.

      Time Complexity :
      O(2ⁿ)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public int findTargetSumWays(int[] nums,
                                 int target) {

        return solve(0,
                     0,
                     nums,
                     target);
    }

    private int solve(int index,
                      int sum,
                      int[] nums,
                      int target) {

        // Base Case
        if (index == nums.length) {

            if (sum == target) {
                return 1;
            }

            return 0;
        }

        // Choose +
        int add = solve(index + 1,
                        sum + nums[index],
                        nums,
                        target);

        // Choose -
        int subtract = solve(index + 1,
                             sum - nums[index],
                             nums,
                             target);

        return add + subtract;
    }

    public static void main(String[] args) {

        TargetSum obj = new TargetSum();

        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        int ways = obj.findTargetSumWays(nums, target);

        System.out.println("Number of Ways : " + ways);
    }
}