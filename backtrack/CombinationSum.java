package backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /*
      Platform : LeetCode

      Question : Combination Sum

      Pattern  : Backtracking

      Approach :
      Pick / Not Pick

      Idea :
      - At every index,
        we have two choices:
          1. Pick the current element.
          2. Skip the current element.
      - If the current element is picked,
        it can be used again, so the
        index remains the same.
      - If the current element is skipped,
        move to the next index.
      - When the remaining target becomes
        zero, store the current combination.
      - Remove the last chosen element
        (Backtrack) before exploring
        the next choice.

      Time Complexity :
      O(2^n)

      Space Complexity :
      O(target)

      (Recursive Call Stack)
    */

    public List<List<Integer>> combinationSum(int[] candidates,
                                              int target) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(candidates,
              target,
              0,
              new ArrayList<>(),
              ans);

        return ans;
    }

    private void solve(int[] arr,
                       int target,
                       int index,
                       List<Integer> list,
                       List<List<Integer>> ans) {

        // Target Achieved
        if (target == 0) {

            ans.add(new ArrayList<>(list));

            return;
        }

        // Base Case
        if (index == arr.length) {
            return;
        }

        // Pick Current Element
        if (arr[index] <= target) {

            list.add(arr[index]);

            solve(arr,
                  target - arr[index],
                  index,
                  list,
                  ans);

            // Backtrack
            list.remove(list.size() - 1);
        }

        // Not Pick Current Element
        solve(arr,
              target,
              index + 1,
              list,
              ans);
    }

    public static void main(String[] args) {

        CombinationSum obj =
                new CombinationSum();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result =
                obj.combinationSum(candidates, target);

        System.out.println("Combinations :");

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}