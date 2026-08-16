package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    /*
      Platform : LeetCode

      Question : Rotting Oranges

      Pattern  : Graph Traversal

      Approach :
      Multi-Source Breadth First
      Search (BFS)

      Idea :
      - First, find all rotten
        oranges and add them to
        the queue.
      - Count all fresh oranges.
      - All initially rotten
        oranges act as multiple
        starting points for BFS.
      - Process the queue level
        by level.
      - Each BFS level represents
        one minute.
      - Check all four directions:
        Up, Down, Left, Right.
      - When a fresh orange is
        found, make it rotten,
        decrease fresh count,
        and add it to the queue.
      - If fresh oranges remain
        after BFS, return -1.
      - Otherwise, return the
        total minutes.

      Time Complexity :
      O(m * n)

      Space Complexity :
      O(m * n)

      (Queue)
    */

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue =
                new LinkedList<>();

        int fresh = 0;
        int minutes = 0;

        int[][] directions = {
                {-1, 0}, // Up
                {1, 0},  // Down
                {0, -1}, // Left
                {0, 1}   // Right
        };

        // Step 1: Find all rotten and fresh oranges
        for (int i = 0;
             i < grid.length;
             i++) {

            for (int j = 0;
                 j < grid[0].length;
                 j++) {

                if (grid[i][j] == 2) {

                    queue.offer(
                            new int[]{i, j});
                }

                if (grid[i][j] == 1) {

                    fresh++;
                }
            }
        }

        // Step 2: BFS
        while (!queue.isEmpty()
                && fresh > 0) {

            int size =
                    queue.size();

            // Process one level = one minute
            for (int i = 0;
                 i < size;
                 i++) {

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
                            || newRow >= grid.length
                            || newCol < 0
                            || newCol >= grid[0].length) {

                        continue;
                    }

                    // Only fresh oranges can become rotten
                    if (grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;

                        fresh--;

                        queue.offer(
                                new int[]{
                                        newRow,
                                        newCol
                                });
                    }
                }
            }

            // One BFS level completed
            minutes++;
        }

        // If fresh oranges still exist
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }

    public static void main(String[] args) {

        RottingOranges obj =
                new RottingOranges();

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int result =
                obj.orangesRotting(grid);

        System.out.println(
                "Minimum Minutes : "
                        + result);
    }
}