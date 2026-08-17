package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    /*
      Platform : LeetCode

      Question : 01 Matrix

      Pattern  : Multi-Source BFS

      Approach :
      Breadth First Search (BFS)

      Idea :
      - Add all cells containing 0
        to the queue.
      - Mark cells containing 1
        as -1 initially.
      - All 0 cells act as multiple
        starting points for BFS.
      - Process each cell and check
        all four directions.
      - If an adjacent cell is -1,
        update its distance using:

        current distance + 1

      - Add the updated cell to
        the queue.

      Time Complexity :
      O(rows * cols)

      Space Complexity :
      O(rows * cols)

      (Answer Matrix + Queue)
    */

    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] ans =
                new int[rows][cols];

        Queue<int[]> queue =
                new LinkedList<>();

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        // Step 1: Add all 0 cells
        // to the queue
        for (int row = 0;
             row < rows;
             row++) {

            for (int col = 0;
                 col < cols;
                 col++) {

                if (mat[row][col] == 0) {

                    ans[row][col] = 0;

                    queue.offer(
                            new int[]{
                                    row,
                                    col
                            });

                } else {

                    ans[row][col] = -1;
                }
            }
        }

        // Step 2: Multi-Source BFS
        while (!queue.isEmpty()) {

            int[] current =
                    queue.poll();

            int row =
                    current[0];

            int col =
                    current[1];

            // Check all 4 directions
            for (int[] dir : directions) {

                int newRow =
                        row + dir[0];

                int newCol =
                        col + dir[1];

                // Boundary check
                if (newRow < 0
                        || newRow >= rows
                        || newCol < 0
                        || newCol >= cols) {

                    continue;
                }

                // Visit unprocessed cell
                if (ans[newRow][newCol] == -1) {

                    ans[newRow][newCol] =
                            ans[row][col] + 1;

                    queue.offer(
                            new int[]{
                                    newRow,
                                    newCol
                            });
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        ZeroOneMatrix obj =
                new ZeroOneMatrix();

        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] result =
                obj.updateMatrix(mat);

        System.out.println(
                "Updated Matrix :");

        for (int i = 0;
             i < result.length;
             i++) {

            for (int j = 0;j < result[0].length;j++) {

                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }
}