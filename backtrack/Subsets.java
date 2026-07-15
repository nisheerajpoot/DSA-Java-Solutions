package backtrack;


import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
      Platform : LeetCode

      Question : Subsets

      Pattern  : Backtracking

      Approach :
      Choice Based Backtracking

      Idea :
      - Start with an empty subset.
      - Store the current subset in
        the answer.
      - From the current index,
        choose one element at a time.
      - Add the chosen element to
        the current subset.
      - Recursively generate all
        subsets starting from the
        next index.
      - Remove the last element
        (Backtrack) and try the
        next choice.

      Time Complexity :
      O(2ⁿ × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index,
                           int[] nums,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Store Current Subset
        ans.add(new ArrayList<>(current));

        // Try Every Choice
        for (int i = index; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, current, ans);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Subsets obj = new Subsets();

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = obj.subsets(nums);

        System.out.println("Subsets :");

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
