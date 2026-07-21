package backtrack;

public class PathWithMaximumGold {

    /*
      Platform : LeetCode

      Question : Path with Maximum Gold

      Pattern  : Backtracking

      Approach :
      DFS + Backtracking

      Idea :
      - Start DFS from every cell
        containing gold.
      - Collect the gold from the
        current cell.
      - Mark the current cell as
        visited by setting its
        value to 0.
      - Explore all four directions:
          1. Up
          2. Down
          3. Left
          4. Right
      - Restore the original gold
        value after recursion
        (Backtrack).
      - Return the current gold plus
        the maximum gold collected
        from the four directions.
      - The answer is the maximum
        gold collected from any
        starting cell.

      Time Complexity :
      O(4^(m × n))

      Space Complexity :
      O(m × n)

      (Recursive Call Stack)
    */

    public int getMaximumGold(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxGold = 0;

        // Try Every Starting Cell
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (grid[row][col] != 0) {

                    maxGold = Math.max(
                            maxGold,
                            dfs(grid, row, col));
                }
            }
        }

        return maxGold;
    }

    private int dfs(int[][] grid,
                    int row,
                    int col) {

        // Base Case
        if (row < 0 ||
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == 0) {

            return 0;
        }

        int gold = grid[row][col];

        // Mark as Visited
        grid[row][col] = 0;

        // Explore Four Directions
        int up = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);

        // Backtrack
        grid[row][col] = gold;

        return gold + Math.max(
                Math.max(up, down),
                Math.max(left, right));
    }

    public static void main(String[] args) {

        PathWithMaximumGold obj =
                new PathWithMaximumGold();

        int[][] grid = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };

        int result = obj.getMaximumGold(grid);

        System.out.println("Maximum Gold : " + result);
    }
}