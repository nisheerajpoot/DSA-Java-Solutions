package backtrack;


import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    /*
      Platform : LeetCode

      Question : Combination Sum III

      Pattern  : Backtracking

      Approach :
      Choice Based Backtracking

      Idea :
      - Choose numbers only from
        1 to 9.
      - Build combinations by
        selecting numbers in
        increasing order.
      - If the combination contains
        exactly k numbers and the
        remaining target becomes zero,
        store the combination.
      - Skip numbers that make the
        target negative.
      - Remove the last chosen number
        (Backtrack) and try the next
        possible choice.

      Time Complexity :
      O(C(9, k) × k)

      Space Complexity :
      O(k)

      (Recursive Call Stack)
    */

    public List<List<Integer>> combinationSum3(int k,
                                               int n) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(1, k, n,
                  new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int start,
                           int k,
                           int target,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Base Case
        if (current.size() == k) {

            if (target == 0) {
                ans.add(new ArrayList<>(current));
            }

            return;
        }

        // Try Every Choice
        for (int i = start; i <= 9; i++) {

            if (i > target) {
                break;
            }

            // Choose
            current.add(i);

            // Explore
            backtrack(i + 1,
                      k,
                      target - i,
                      current,
                      ans);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        CombinationSumIII obj =
                new CombinationSumIII();

        int k = 3;
        int n = 7;

        List<List<Integer>> result =
                obj.combinationSum3(k, n);

        System.out.println("Combinations :");

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}