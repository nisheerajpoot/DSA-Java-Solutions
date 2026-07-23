package backtrack;

import java.util.ArrayList;

public class AllPossiblePathsFromTopLeftToBottomRight {

    /*
      Platform : GeeksforGeeks

      Question : Find All Possible Paths
                 from Top Left to Bottom Right

      Pattern  : Backtracking

      Approach :
      DFS + Backtracking

      Idea :
      - Start from the top-left cell.
      - Store the current cell
        in the current path.
      - From each cell, there are
        two possible moves:
          1. Right
          2. Down
      - When the destination is
        reached, store the current
        path.
      - Remove the last element
        before returning to explore
        another path (Backtrack).

      Time Complexity :
      O(2^(m + n))

      Space Complexity :
      O(m + n)

      (Recursive Call Stack +
       Current Path)

      Where :
      m = Number of Rows
      n = Number of Columns
    */

    public static ArrayList<ArrayList<Integer>> allPaths(int[][] mat) {

        ArrayList<ArrayList<Integer>> ans =
                new ArrayList<>();

        ArrayList<Integer> path =
                new ArrayList<>();

        backtrack(0,
                  0,
                  mat,
                  path,
                  ans);

        return ans;
    }

    private static void backtrack(int row,
                                  int col,
                                  int[][] mat,
                                  ArrayList<Integer> path,
                                  ArrayList<ArrayList<Integer>> ans) {

        int rows = mat.length;
        int cols = mat[0].length;

        // Out of Boundary
        if (row >= rows ||
            col >= cols) {
            return;
        }

        // Include Current Cell
        path.add(mat[row][col]);

        // Destination Reached
        if (row == rows - 1 &&
            col == cols - 1) {

            ans.add(new ArrayList<>(path));
        }

        else {

            // Move Right
            backtrack(row,
                      col + 1,
                      mat,
                      path,
                      ans);

            // Move Down
            backtrack(row + 1,
                      col,
                      mat,
                      path,
                      ans);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        ArrayList<ArrayList<Integer>> result =
                allPaths(mat);

        System.out.println("All Possible Paths :");

        for (ArrayList<Integer> path : result) {
            System.out.println(path);
        }
    }
}