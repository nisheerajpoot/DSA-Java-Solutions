package backtrack;


import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /*
      Platform : LeetCode

      Question : Permutations

      Pattern  : Backtracking

      Approach :
      Swap Based Backtracking

      Idea :
      - Fix one position at a time.
      - Swap the current element
        with every possible element
        from the current index onward.
      - Recursively generate
        permutations for the
        remaining positions.
      - After recursion, swap the
        elements back (Backtrack)
        to restore the original array.
      - When all positions are fixed,
        store the current permutation.

      Time Complexity :
      O(n! × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

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

        // Try Every Choice
        for (int i = index; i < nums.length; i++) {

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

        Permutations obj = new Permutations();

        int[] nums = {1, 2, 3};

        List<List<Integer>> result =
                obj.permute(nums);

        System.out.println("Permutations :");

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}