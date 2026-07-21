package backtrack;

import java.util.ArrayList;

public class RatInAMaze {

    /*
      Platform : GeeksforGeeks

      Question : Rat in a Maze Problem - I

      Pattern  : Backtracking

      Approach :
      DFS + Backtracking

      Idea :
      - Start from the top-left cell.
      - The rat can move in four
        directions:
          1. Down
          2. Left
          3. Right
          4. Up
      - Move only to cells that are:
          • Inside the maze.
          • Not visited.
          • Have value 1.
      - Mark the current cell as
        visited before exploring.
      - Add the move to the current
        path.
      - After recursion, remove the
        move and unmark the cell
        (Backtrack).
      - When the destination is
        reached, store the path.

      Time Complexity :
      O(4^(n × n))

      Space Complexity :
      O(n × n)

      (Visited Array +
       Recursive Call Stack)
    */

    ArrayList<String> ans = new ArrayList<>();

    public ArrayList<String> ratInMaze(int[][] mat) {

        int n = mat.length;

        // No Valid Path
        if (mat[0][0] == 0 ||
            mat[n - 1][n - 1] == 0) {

            return ans;
        }

        boolean[][] visited =
                new boolean[n][n];

        solve(0,
              0,
              mat,
              visited,
              new StringBuilder());

        return ans;
    }

    private void solve(int row,
                       int col,
                       int[][] mat,
                       boolean[][] visited,
                       StringBuilder path) {

        int n = mat.length;

        // Destination Reached
        if (row == n - 1 &&
            col == n - 1) {

            ans.add(path.toString());

            return;
        }

        // Mark as Visited
        visited[row][col] = true;

        // Down
        if (isSafe(row + 1,
                   col,
                   mat,
                   visited)) {

            path.append('D');

            solve(row + 1,
                  col,
                  mat,
                  visited,
                  path);

            path.deleteCharAt(path.length() - 1);
        }

        // Left
        if (isSafe(row,
                   col - 1,
                   mat,
                   visited)) {

            path.append('L');

            solve(row,
                  col - 1,
                  mat,
                  visited,
                  path);

            path.deleteCharAt(path.length() - 1);
        }

        // Right
        if (isSafe(row,
                   col + 1,
                   mat,
                   visited)) {

            path.append('R');

            solve(row,
                  col + 1,
                  mat,
                  visited,
                  path);

            path.deleteCharAt(path.length() - 1);
        }

        // Up
        if (isSafe(row - 1,
                   col,
                   mat,
                   visited)) {

            path.append('U');

            solve(row - 1,
                  col,
                  mat,
                  visited,
                  path);

            path.deleteCharAt(path.length() - 1);
        }

        // Backtrack
        visited[row][col] = false;
    }

    private boolean isSafe(int row,
                           int col,
                           int[][] mat,
                           boolean[][] visited) {

        int n = mat.length;

        return row >= 0 &&
               col >= 0 &&
               row < n &&
               col < n &&
               mat[row][col] == 1 &&
               !visited[row][col];
    }

    public static void main(String[] args) {

        RatInAMaze obj = new RatInAMaze();

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        ArrayList<String> paths =
                obj.ratInMaze(maze);

        System.out.println("Possible Paths :");

        for (String path : paths) {
            System.out.println(path);
        }
    }
}