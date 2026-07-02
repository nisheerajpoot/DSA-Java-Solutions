package recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetsII {

    /*
      Platform : LeetCode

      Question : Subsets II

      Pattern  : Recursion + Backtracking

      Approach :
      For Loop + Backtracking

      Idea :
      - Sort the array so that duplicate
        elements become adjacent.
      - Add the current subset to the answer
        at every recursive call.
      - Iterate through the remaining elements.
      - Skip duplicate elements at the
        same recursion level.
      - Choose the current element,
        recursively generate further subsets,
        then backtrack by removing it.

      Time Complexity :
      O(n × 2^n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)

      Note :
      If output space is considered,
      the total space complexity becomes
      O(n × 2^n).
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

        for (int i = index; i < nums.length; i++) {

            // Skip Duplicates
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose Current Element
            list.add(nums[i]);

            // Recursive Call
            solve(nums, i + 1, list, ans);

            // Backtrack
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SubsetsII obj = new SubsetsII();

        List<List<Integer>> ans = obj.subsetsWithDup(nums);

        System.out.println(ans);

        sc.close();
    }
}
