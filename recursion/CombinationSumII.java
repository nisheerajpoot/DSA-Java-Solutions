package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumII {

    /*
      Platform : LeetCode

      Question : Combination Sum II

      Pattern  : Recursion + Backtracking

      Approach :
      For Loop + Backtracking

      Idea :
      - Sort the array so that duplicate
        elements become adjacent.
      - Iterate through the candidates
        starting from the current index.
      - Skip duplicate elements at the
        same recursion level.
      - If the current element is greater
        than the remaining target,
        stop exploring further.
      - Include the current element and
        recursively search using the
        next index because each element
        can be used only once.
      - Backtrack after returning from
        the recursive call.

      Time Complexity :
      O(2^n)

      (Approximate, depends on the
      number of valid combinations)

      Space Complexity :
      O(n)

      (Recursive Call Stack +
      Current Combination)
    */

    public List<List<Integer>> combinationSum2(int[] candidates,  int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        solve(candidates, target, 0, new ArrayList<>(), ans);

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

        for (int i = index; i < arr.length; i++) {

            // Skip Duplicates
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            // No Valid Combination Ahead
            if (arr[i] > target) {
                break;
            }

            // Choose Current Element
            list.add(arr[i]);

            solve(arr, target - arr[i], i + 1, list, ans);

            // Backtrack
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] candidates = new int[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        CombinationSumII obj = new CombinationSumII();

        List<List<Integer>> ans =
                obj.combinationSum2(candidates, target);

        System.out.println(ans);

        sc.close();
    }
}