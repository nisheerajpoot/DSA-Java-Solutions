package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {

    /*
      Platform : LeetCode

      Question : Combination Sum

      Pattern  : Recursion + Backtracking

      Approach :
      Include / Exclude

      Idea :
      - For every number, there are
        two choices:
          1. Include the current number.
             Since the same number can be
             used multiple times, stay at
             the same index.
          2. Exclude the current number
             and move to the next index.
      - If the target becomes 0,
        a valid combination is found.
      - If all elements are processed,
        stop the recursion.

      Time Complexity :
      O(2^target)

      (Approximate, depends on the
      target value and valid combinations)

      Space Complexity :
      O(target)

      (Recursive Call Stack +
      Current Combination)
    */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int[] arr,
                       int target,
                       int index,
                       List<Integer> list,
                       List<List<Integer>> ans) {

        // Base Case : Combination Found
        if (target == 0) {

            ans.add(new ArrayList<>(list));
            return;
        }

        // Base Case : No Elements Left
        if (index == arr.length) {
            return;
        }

        // Include Current Element
        if (arr[index] <= target) {

            list.add(arr[index]);

            solve(arr, target - arr[index], index, list, ans);

            // Backtrack
            list.remove(list.size() - 1);
        }

        // Exclude Current Element
        solve(arr, target, index + 1, list, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] candidates = new int[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        CombinationSum obj = new CombinationSum();

        List<List<Integer>> ans =
                obj.combinationSum(candidates, target);

        System.out.println(ans);

        sc.close();
    }
}