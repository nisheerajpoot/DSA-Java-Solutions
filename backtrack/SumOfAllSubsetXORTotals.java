package backtracking_pattern;

public class SumOfAllSubsetXORTotals {

    /*
      Platform : LeetCode

      Question : Sum of All Subset XOR Totals

      Pattern  : Backtracking

      Approach :
      Include / Exclude Backtracking

      Idea :
      - For every element, there are
        two choices:
          1. Include it in the subset.
          2. Exclude it from the subset.
      - Maintain the XOR value of the
        current subset.
      - If the element is included,
        update XOR using (^).
      - When all elements are
        processed, return the XOR
        value of that subset.
      - Add the XOR totals of all
        possible subsets.

      Time Complexity :
      O(2ⁿ)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public int subsetXORSum(int[] nums) {

        return backtrack(0, 0, nums);
    }

    private int backtrack(int index,
                          int xor,
                          int[] nums) {

        // Base Case
        if (index == nums.length) {
            return xor;
        }

        // Include Current Element
        int take =
                backtrack(index + 1,
                          xor ^ nums[index],
                          nums);

        // Exclude Current Element
        int skip =
                backtrack(index + 1,
                          xor,
                          nums);

        return take + skip;
    }

    public static void main(String[] args) {

        SumOfAllSubsetXORTotals obj =
                new SumOfAllSubsetXORTotals();

        int[] nums = {1, 3};

        int result =
                obj.subsetXORSum(nums);

        System.out.println(
                "Sum of All Subset XOR Totals : "
                        + result);
    }
}