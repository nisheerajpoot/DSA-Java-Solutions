package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {

    /*
      Platform : LeetCode

      Question : Permutations

      Pattern  : Recursion + Backtracking

      Approach :
      Backtracking with Visited Array

      Idea :
      - Generate permutations by choosing
        one unused element at a time.
      - Use a visited array to keep track
        of elements already included in
        the current permutation.
      - If the current permutation size
        becomes equal to the array size,
        store it in the answer.
      - Backtrack by removing the last
        element and marking it as unused.

      Time Complexity :
      O(n × n!)

      Space Complexity :
      O(n)

      (Visited Array +
      Recursive Call Stack)

      Note :
      If output space is considered,
      the total space complexity becomes
      O(n × n!).
    */

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        solve(nums, visited, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int[] nums,
                       boolean[] visited,
                       List<Integer> list,
                       List<List<Integer>> ans) {

        // Base Case
        if (list.size() == nums.length) {

            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip Already Used Element
            if (visited[i]) {
                continue;
            }

            // Choose Current Element
            visited[i] = true;
            list.add(nums[i]);

            // Recursive Call
            solve(nums, visited, list, ans);

            // Backtrack
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Permutations obj = new Permutations();

        List<List<Integer>> ans = obj.permute(nums);

        System.out.println(ans);

        sc.close();
    }
}