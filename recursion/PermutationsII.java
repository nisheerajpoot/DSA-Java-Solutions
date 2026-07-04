package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class PermutationsII {

    /*
      Platform : LeetCode

      Question : Permutations II

      Pattern  : Recursion + Backtracking

      Approach :
      Swap Backtracking + HashSet

      Idea :
      - Generate permutations by fixing
        one element at each index.
      - Swap the current index with every
        possible element.
      - Use a HashSet at each recursion
        level to avoid fixing the same
        value more than once.
      - After the recursive call,
        backtrack by swapping the
        elements again.
      - When all positions are fixed,
        store the permutation.

      Time Complexity :
      O(n × n!)

      (Approximate)

      Space Complexity :
      O(n)

      (Recursive Call Stack)

      Note :
      A HashSet is created at every
      recursion level to skip duplicate
      values and generate only unique
      permutations.
    */

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        solve(nums, 0);

        return ans;
    }

    private void solve(int[] nums, int index) {

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

        for (int i = index; i < nums.length; i++) {

            // Skip Duplicate Values
            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);

            // Swap
            swap(nums, index, i);

            // Recursive Call
            solve(nums, index + 1);

            // Backtrack
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        PermutationsII obj = new PermutationsII();

        List<List<Integer>> ans = obj.permuteUnique(nums);

        System.out.println(ans);

        sc.close();
    }
}