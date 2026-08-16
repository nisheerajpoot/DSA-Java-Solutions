package graph;

public class NumberOfIslands {

    /*
      Platform : LeetCode

      Question : Number of Islands

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Traverse every cell of
        the grid.
      - If a cell contains '1',
        a new island is found.
      - Increase the island count.
      - Use DFS to visit all
        connected land cells.
      - Mark every visited land
        cell as '0' so it is not
        counted again.
      - Check all four directions:
        Up, Down, Left, Right.

      Time Complexity :
      O(m * n)

      Space Complexity :
      O(m * n)

      (Recursive Call Stack)
    */

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int row = 0;
             row < grid.length;
             row++) {

            for (int col = 0;
                 col < grid[0].length;
                 col++) {

                if (grid[row][col] == '1') {

                    count++;

                    dfs(grid,
                        row,
                        col);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid,
                    int row,
                    int col) {

        if (row < 0
                || row >= grid.length
                || col < 0
                || col >= grid[0].length) {

            return;
        }

        if (grid[row][col] != '1') {

            return;
        }

        grid[row][col] = '0';

        dfs(grid,
            row - 1,
            col);

        dfs(grid,
            row + 1,
            col);

        dfs(grid,
            row,
            col - 1);

        dfs(grid,
            row,
            col + 1);
    }

    public static void main(String[] args) {

        NumberOfIslands obj =
                new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result =
                obj.numIslands(grid);

        System.out.println(
                "Number of Islands : "
                        + result);
    }
}