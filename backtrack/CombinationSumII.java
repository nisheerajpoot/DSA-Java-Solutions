package backtrack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    /*
      Platform : LeetCode

      Question : Combination Sum II

      Pattern  : Backtracking

      Approach :
      Choice Based Backtracking

      Idea :
      - Sort the array so that duplicate
        elements become adjacent.
      - From the current index,
        choose one element at a time.
      - Each element can be used
        only once.
      - Skip duplicate elements at
        the same recursion level to
        avoid duplicate combinations.
      - If the remaining target
        becomes zero, store the
        current combination.
      - Remove the last chosen element
        (Backtrack) and continue with
        the next choice.

      Time Complexity :
      O(2ⁿ × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<List<Integer>> combinationSum2(int[] candidates,
                                               int target) {

        Arrays.sort(candidates);

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

        // Base Case
        if (target == 0) {

            ans.add(new ArrayList<>(list));

            return;
        }

        // Try Every Choice
        for (int i = index; i < arr.length; i++) {

            // Skip Duplicate Elements
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            // No Valid Combination Possible
            if (arr[i] > target) {
                break;
            }

            // Choose
            list.add(arr[i]);

            // Explore
            solve(arr,
                  target - arr[i],
                  i + 1,
                  list,
                  ans);

            // Backtrack
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        CombinationSumII obj =
                new CombinationSumII();

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result =
                obj.combinationSum2(candidates, target);

        System.out.println("Combinations :");

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
