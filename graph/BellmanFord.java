package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    /*
      Platform : GeeksforGeeks

      Question : Bellman-Ford Algorithm

      Pattern  : Shortest Path

      Approach : Bellman-Ford

      Idea :
      - Distance array ko infinity se initialize karenge.
      - Source ka distance = 0.
      - V - 1 times saare edges ko relax karenge.
      - Relaxation:
            if (dist[u] + wt < dist[v])
                dist[v] = dist[u] + wt
      - V - 1 iterations ke baad shortest distances
        mil jaati hain.
      - Ek extra iteration mein agar distance
        further reduce hota hai, to negative cycle
        present hai.
      - Negative cycle milne par [-1] return karenge.

      Important :
      - Bellman-Ford negative edge weights handle kar sakta hai.
      - Negative cycle detect kar sakta hai.
      - Graph directed edges ke form mein process hota hai.

      Time Complexity :
      O(V * E)

      Space Complexity :
      O(V)
    */

    public ArrayList<Integer> bellmanFord(
            int V,
            int[][] edges,
            int src) {

        // Distance array
        int[] dist =
                new int[V];

        Arrays.fill(
                dist,
                (int) 1e8);

        // Source distance
        dist[src] = 0;

        // Relax all edges V - 1 times
        for (int i = 0;
             i < V - 1;
             i++) {

            for (int[] edge :
                    edges) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                // Relaxation
                if (dist[u] != (int) 1e8 &&
                    dist[u] + wt < dist[v]) {

                    dist[v] =
                            dist[u] + wt;
                }
            }
        }

        // Check for negative cycle
        for (int[] edge :
                edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != (int) 1e8 &&
                dist[u] + wt < dist[v]) {

                ArrayList<Integer> result =
                        new ArrayList<>();

                result.add(-1);

                return result;
            }
        }

        // Build result
        ArrayList<Integer> result =
                new ArrayList<>();

        for (int i = 0;
             i < V;
             i++) {

            result.add(
                    dist[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        BellmanFord obj =
                new BellmanFord();

        int V = 5;

        int[][] edges = {
                {0, 1, 2},
                {0, 2, 4},
                {1, 2, -1},
                {1, 3, 2},
                {2, 3, 3},
                {3, 4, 1}
        };

        int src = 0;

        ArrayList<Integer> result =
                obj.bellmanFord(
                        V,
                        edges,
                        src);

        System.out.println(
                "Shortest Distances : "
                        + result);
    }
}