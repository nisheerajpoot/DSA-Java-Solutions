package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    /*
      Platform : GeeksforGeeks

      Question : Shortest Path in a Binary Matrix

      Pattern  : Shortest Path

      Approach : BFS

      Idea :
      - Matrix ke har cell ko graph ka node maan sakte hain.
      - Sirf value 1 wale cells par move kar sakte hain.
      - BFS use karenge because every move has
        equal cost = 1.
      - Queue mein row, column aur distance store karenge.
      - 4 directions mein move karenge:
          Up
          Down
          Left
          Right
      - Destination milte hi shortest distance return karenge.
      - Agar destination unreachable hai,
        return -1.

      Time Complexity :
      O(N * M)

      Space Complexity :
      O(N * M)
    */

    static class Pair {

        int row;
        int col;
        int distance;

        Pair(int row, int col, int distance) {

            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int shortestPath(
            int[][] mat,
            int[] src,
            int[] dest) {

        int n = mat.length;
        int m = mat[0].length;

        // Source or destination blocked
        if (mat[src[0]][src[1]] == 0 ||
            mat[dest[0]][dest[1]] == 0) {

            return -1;
        }

        // Source and destination are same
        if (src[0] == dest[0] &&
            src[1] == dest[1]) {

            return 0;
        }

        // Visited array
        boolean[][] visited =
                new boolean[n][m];

        // BFS queue
        Queue<Pair> q =
                new LinkedList<>();

        q.offer(
                new Pair(
                        src[0],
                        src[1],
                        0));

        visited[src[0]][src[1]] = true;

        // Four directions
        int[] dRow =
                {-1, 1, 0, 0};

        int[] dCol =
                {0, 0, -1, 1};

        // BFS
        while (!q.isEmpty()) {

            Pair current =
                    q.poll();

            int row =
                    current.row;

            int col =
                    current.col;

            int distance =
                    current.distance;

            // Explore 4 directions
            for (int i = 0;
                 i < 4;
                 i++) {

                int newRow =
                        row + dRow[i];

                int newCol =
                        col + dCol[i];

                // Valid cell
                if (newRow >= 0 &&
                    newRow < n &&
                    newCol >= 0 &&
                    newCol < m &&
                    mat[newRow][newCol] == 1 &&
                    !visited[newRow][newCol]) {

                    // Destination reached
                    if (newRow == dest[0] &&
                        newCol == dest[1]) {

                        return distance + 1;
                    }

                    visited[newRow][newCol] = true;

                    q.offer(
                            new Pair(
                                    newRow,
                                    newCol,
                                    distance + 1));
                }
            }
        }

        // Destination unreachable
        return -1;
    }

    public static void main(String[] args) {

        ShortestPathBinaryMatrix obj =
                new ShortestPathBinaryMatrix();

        int[][] mat = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };

        int[] src = {0, 0};

        int[] dest = {3, 3};

        int result =
                obj.shortestPath(
                        mat,
                        src,
                        dest);

        System.out.println(
                "Shortest Distance : "
                        + result);
    }
}