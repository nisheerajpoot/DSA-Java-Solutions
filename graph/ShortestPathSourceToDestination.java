package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathSourceToDestination {

    /*
      Platform : GeeksforGeeks

      Question : Shortest Path in an Unweighted Graph

      Pattern  : Shortest Path

      Approach : BFS

      Idea :
      - Create an adjacency list.
      - Initialize distance array with -1.
      - Start BFS from src.
      - When a node is visited for the first time,
        its shortest distance is found.
      - If we reach dest, return its distance.
      - If dest is unreachable, return -1.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)
    */

    public int shortestPath(
            int V,
            int[][] edges,
            int src,
            int dest) {

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        // Create adjacency list
        for (int i = 0;
             i < V;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Add edges
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Distance array
        int[] dist =
                new int[V];

        Arrays.fill(dist, -1);

        // BFS queue
        Queue<Integer> q =
                new LinkedList<>();

        q.add(src);

        dist[src] = 0;

        // BFS
        while (!q.isEmpty()) {

            int node =
                    q.poll();

            // Destination reached
            if (node == dest) {

                return dist[node];
            }

            for (int neighbor :
                    adj.get(node)) {

                if (dist[neighbor] == -1) {

                    dist[neighbor] =
                            dist[node] + 1;

                    q.add(neighbor);
                }
            }
        }

        // Destination unreachable
        return -1;
    }

    public static void main(String[] args) {

        ShortestPathSourceToDestination obj =
                new ShortestPathSourceToDestination();

        int V = 6;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5}
        };

        int src = 0;
        int dest = 5;

        int result =
                obj.shortestPath(
                        V,
                        edges,
                        src,
                        dest);

        System.out.println(
                "Shortest Distance : "
                        + result);
    }
}