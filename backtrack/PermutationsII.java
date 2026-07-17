package backtrack;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

    /*
      Platform : LeetCode

      Question : Permutations II

      Pattern  : Backtracking

      Approach :
      Swap Based Backtracking

      Idea :
      - Fix one position at a time.
      - Swap the current element with
        every possible element from the
        current index onward.
      - Use a HashSet at each recursion
        level to avoid choosing the same
        value more than once.
      - Recursively generate
        permutations for the remaining
        positions.
      - Undo the swap (Backtrack) before
        trying the next choice.
      - When all positions are fixed,
        store the current permutation.

      Time Complexity :
      O(n! × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        solve(nums, 0);

        return ans;
    }

    private void solve(int[] nums,
                       int index) {

        // Base Case
        if (index == nums.length) {

            List<Integer> temp = new ArrayList<>();

            for (int num : nums) {
                temp.add(num);
            }

            ans.add(temp);

            return;
        }

        HashSet<Integer> set = new HashSet<>();

        // Try Every Choice
        for (int i = index; i < nums.length; i++) {

            // Skip Duplicate Values
            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);

            // Choose
            swap(nums, index, i);

            // Explore
            solve(nums, index + 1);

            // Backtrack
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums,
                      int i,
                      int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        PermutationsII obj = new PermutationsII();

        int[] nums = {1, 1, 2};

        List<List<Integer>> result =
                obj.permuteUnique(nums);

        System.out.println("Unique Permutations :");

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
