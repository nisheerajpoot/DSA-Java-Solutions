package backtrack;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {

    /*
      Platform : GeeksforGeeks

      Question : Subset Sums

      Pattern  : Backtracking

      Approach :
      Pick / Not Pick

      Idea :
      - At every element,
        we have two choices:
          1. Include the current element
             in the subset sum.
          2. Exclude the current element.
      - Continue recursively until
        all elements are processed.
      - When the end of the array is
        reached, store the current sum.
      - Finally, sort all subset sums
        before returning.

      Time Complexity :
      O(2ⁿ × n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public ArrayList<Integer> subsetSums(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        solve(arr, 0, 0, ans);

        Collections.sort(ans);

        return ans;
    }

    private void solve(int[] arr,
                       int index,
                       int sum,
                       ArrayList<Integer> ans) {

        // Base Case
        if (index == arr.length) {

            ans.add(sum);

            return;
        }

        // Pick Current Element
        solve(arr, index + 1,
              sum + arr[index], ans);

        // Not Pick Current Element
        solve(arr, index + 1,
              sum, ans);
    }

    public static void main(String[] args) {

        SubsetSums obj = new SubsetSums();

        int[] arr = {2, 3};

        ArrayList<Integer> result = obj.subsetSums(arr);

        System.out.println("Subset Sums : " + result);
    }
}