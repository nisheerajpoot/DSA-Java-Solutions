package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBFS {

    /*
      Platform : GeeksforGeeks

      Question : Shortest Path in an Unweighted Graph

      Pattern  : Shortest Path

      Approach : BFS

      Idea :
      - Create an adjacency list.
      - Initialize distance array with -1.
      - Start BFS from node 0.
      - When a node is visited for the first time,
        its shortest distance is found.
      - distance[neighbor] = distance[node] + 1.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)
    */

    public ArrayList<Integer> shortestPath(
            int V,
            int[][] edges) {

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        for (int i = 0;
             i < V;
             i++) {

            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist =
                new int[V];

        Arrays.fill(dist, -1);

        Queue<Integer> q =
                new LinkedList<>();

        q.add(0);

        dist[0] = 0;

        while (!q.isEmpty()) {

            int node =
                    q.poll();

            for (int neighbor :
                    adj.get(node)) {

                if (dist[neighbor] == -1) {

                    dist[neighbor] =
                            dist[node] + 1;

                    q.add(neighbor);
                }
            }
        }

        ArrayList<Integer> ans =
                new ArrayList<>();

        for (int d : dist) {

            ans.add(d);
        }

        return ans;
    }

    public static void main(String[] args) {

        ShortestPathBFS obj =
                new ShortestPathBFS();

        int V = 9;

        int[][] edges = {
                {0, 1},
                {0, 3},
                {1, 2},
                {1, 4},
                {2, 5},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 7},
                {7, 8}
        };

        ArrayList<Integer> result =
                obj.shortestPath(V, edges);

        System.out.println(
                "Shortest Path : "
                        + result);
    }
}