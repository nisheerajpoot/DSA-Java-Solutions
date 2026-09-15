package graph;

import java.util.Arrays;

public class FloydWarshall {

    /*
     * ============================================================
     * Platform   : GeeksforGeeks
     * Problem    : Floyd Warshall
     * Pattern    : All-Pairs Shortest Path
     *
     * Approach:
     * 1. Try every vertex 'k' as an intermediate vertex.
     * 2. For every source 'i' and destination 'j',
     *    check whether i -> k -> j is shorter than i -> j.
     * 3. Update the distance if a shorter path is found.
     *
     * Formula:
     * dist[i][j] = min(dist[i][j],
     *                  dist[i][k] + dist[k][j])
     *
     * Time Complexity  : O(V^3)
     * Space Complexity : O(1)
     * ============================================================
     */

    public void floydWarshall(int[][] dist) {

        int n = dist.length;

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (dist[i][k] != 100000000 &&
                        dist[k][j] != 100000000) {

                        dist[i][j] = Math.min(
                                dist[i][j],
                                dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        FloydWarshall obj = new FloydWarshall();

        int INF = 100000000;

        int[][] dist = {
                {0,   5,  10},
                {INF, 0,   3},
                {INF, INF, 0}
        };

        obj.floydWarshall(dist);

        System.out.println("Shortest Distance Matrix:");

        for (int[] row : dist) {
            System.out.println(Arrays.toString(row));
        }
    }
}