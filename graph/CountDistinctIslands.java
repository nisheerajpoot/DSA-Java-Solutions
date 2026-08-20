package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDistinctIslands {

    /*
      Platform : GeeksforGeeks

      Question : Count Distinct Islands

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Traverse every cell of
        the grid.
      - When an unvisited land
        cell 'L' is found, start DFS.
      - Store the shape of the island
        using relative coordinates.
      - Calculate:

        relativeRow = row - baseRow
        relativeCol = col - baseCol

      - Islands with the same list
        of relative coordinates are
        considered the same shape.
      - Store every unique shape
        inside a HashSet.
      - Return the total number of
        unique shapes.

      Time Complexity :
      O(rows * cols)

      Space Complexity :
      O(rows * cols)

      (Visited Array +
       HashSet +
       Recursive Call Stack)
    */

    public int countDistinctIslands(
            char[][] grid) {

        int rows =
                grid.length;

        int cols =
                grid[0].length;

        boolean[][] visited =
                new boolean[rows][cols];

        Set<List<String>> shapes =
                new HashSet<>();

        for (int row = 0;
             row < rows;
             row++) {

            for (int col = 0;
                 col < cols;
                 col++) {

                if (grid[row][col] == 'L'
                        && !visited[row][col]) {

                    List<String> shape =
                            new ArrayList<>();

                    dfs(grid,
                        row,
                        col,
                        row,
                        col,
                        visited,
                        shape);

                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }

    public void dfs(
            char[][] grid,
            int row,
            int col,
            int baseRow,
            int baseCol,
            boolean[][] visited,
            List<String> shape) {

        if (row < 0
                || row >= grid.length
                || col < 0
                || col >= grid[0].length) {

            return;
        }

        if (grid[row][col] == 'W'
                || visited[row][col]) {

            return;
        }

        visited[row][col] = true;

        int relativeRow =
                row - baseRow;

        int relativeCol =
                col - baseCol;

        shape.add(
                relativeRow
                        + ","
                        + relativeCol);

        dfs(grid,
            row - 1,
            col,
            baseRow,
            baseCol,
            visited,
            shape);

        dfs(grid,
            row + 1,
            col,
            baseRow,
            baseCol,
            visited,
            shape);

        dfs(grid,
            row,
            col - 1,
            baseRow,
            baseCol,
            visited,
            shape);

        dfs(grid,
            row,
            col + 1,
            baseRow,
            baseCol,
            visited,
            shape);
    }

    public static void main(String[] args) {

        CountDistinctIslands obj =
                new CountDistinctIslands();

        char[][] grid = {
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'L', 'W', 'W'},
                {'W', 'L', 'L', 'L', 'W'}
        };

        int result =obj.countDistinctIslands(grid);

        System.out.println("Number of Distinct Islands : "+ result);
    }
}