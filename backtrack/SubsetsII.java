package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    /*
      Platform : LeetCode

      Question : Subsets II

      Pattern  : Backtracking

      Approach :
      Choice Based Backtracking

      Idea :
      - Sort the array so that duplicate
        elements become adjacent.
      - Store the current subset in
        the answer.
      - From the current index,
        choose one element at a time.
      - Skip duplicate elements at the
        same recursion level to avoid
        generating duplicate subsets.
      - Add the chosen element and
        recursively generate subsets.
      - Remove the last element
        (Backtrack) and continue with
        the next choice.

      Time Complexity :
      O(2ⁿ × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int[] nums,
                       int index,
                       List<Integer> list,
                       List<List<Integer>> ans) {

        // Store Current Subset
        ans.add(new ArrayList<>(list));

        // Try Every Choice
        for (int i = index; i < nums.length; i++) {

            // Skip Duplicate Elements
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            list.add(nums[i]);

            // Explore
            solve(nums, i + 1, list, ans);

            // Backtrack
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        SubsetsII obj = new SubsetsII();

        int[] nums = {1, 2, 2};

        List<List<Integer>> result = obj.subsetsWithDup(nums);

        System.out.println("Unique Subsets :");

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}