package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    /*
      Platform : LeetCode

      Question : Number of Enclaves

      Pattern  : Graph Traversal

      Approach :
      Breadth First Search (BFS)

      Idea :
      - First, add all boundary
        land cells to the queue.
      - Mark boundary land as 0
        because it cannot be an
        enclave.
      - Use BFS to visit all land
        cells connected to the
        boundary.
      - Mark all connected land
        cells as 0.
      - Finally, count the remaining
        cells containing 1.
      - These remaining cells are
        enclaves.

      Time Complexity :
      O(rows * cols)

      Space Complexity :
      O(rows * cols)

      (Queue)
    */

    public int numEnclaves(int[][] grid) {

        int rows =
                grid.length;

        int cols =
                grid[0].length;

        int count = 0;

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        Queue<int[]> queue =
                new LinkedList<>();

        // Check First and Last Row
        for (int col = 0;
             col < cols;
             col++) {

            if (grid[0][col] == 1) {

                queue.offer(
                        new int[]{0, col});

                grid[0][col] = 0;
            }

            if (grid[rows - 1][col] == 1) {

                queue.offer(
                        new int[]{
                                rows - 1,
                                col
                        });

                grid[rows - 1][col] = 0;
            }
        }

        // Check First and Last Column
        for (int row = 0;
             row < rows;
             row++) {

            if (grid[row][0] == 1) {

                queue.offer(
                        new int[]{row, 0});

                grid[row][0] = 0;
            }

            if (grid[row][cols - 1] == 1) {

                queue.offer(
                        new int[]{
                                row,
                                cols - 1
                        });

                grid[row][cols - 1] = 0;
            }
        }

        // BFS
        while (!queue.isEmpty()) {

            int[] current =
                    queue.poll();

            int row =
                    current[0];

            int col =
                    current[1];

            for (int[] dir : directions) {

                int newRow =
                        row + dir[0];

                int newCol =
                        col + dir[1];

                // Boundary Check
                if (newRow < 0
                        || newRow >= rows
                        || newCol < 0
                        || newCol >= cols) {

                    continue;
                }

                // Connected land found
                if (grid[newRow][newCol] == 1) {

                    // Mark as visited
                    // / not an enclave
                    grid[newRow][newCol] = 0;

                    queue.offer(
                            new int[]{
                                    newRow,
                                    newCol
                            });
                }
            }
        }

        // Count Remaining Land
        for (int row = 0;
             row < rows;
             row++) {

            for (int col = 0;
                 col < cols;
                 col++) {

                if (grid[row][col] == 1) {

                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        NumberOfEnclaves obj =
                new NumberOfEnclaves();

        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int result =
                obj.numEnclaves(grid);

        System.out.println(
                "Number of Enclaves : "
                        + result);
    }
}