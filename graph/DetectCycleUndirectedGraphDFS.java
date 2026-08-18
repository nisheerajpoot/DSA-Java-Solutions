package graph;

import java.util.ArrayList;

public class DetectCycleUndirectedGraphDFS {

    /*
      Platform : GeeksforGeeks

      Question : Detect Cycle in an
                 Undirected Graph

      Pattern  : Graph Cycle Detection

      Approach :
      Depth First Search (DFS)
      + Parent Tracking

      Idea :
      - Create an adjacency list
        from the given edges.
      - Traverse every node because
        the graph may be disconnected.
      - For each unvisited node,
        start DFS.
      - Mark the current node as
        visited.
      - Pass the parent node during
        the DFS call.
      - If a neighbor is not visited,
        recursively visit it.
      - If a neighbor is already
        visited and it is not the
        parent, a cycle exists.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)

      (Adjacency List +
       Visited Array +
       Recursive Call Stack)
    */

    public boolean isCycle(int V,
                           int[][] edges) {

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        for (int i = 0;
             i < V;
             i++) {

            adj.add(
                    new ArrayList<>());
        }

        // Create Undirected Graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited =
                new boolean[V];

        // Check every component
        for (int node = 0;
             node < V;
             node++) {

            if (!visited[node]) {

                if (dfs(node,
                        -1,
                        adj,
                        visited)) {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(
            int node,
            int parent,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

        visited[node] = true;

        for (int neighbor :
                adj.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor,
                        node,
                        adj,
                        visited)) {

                    return true;
                }
            }

            // If already visited
            // and it is not the parent
            else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        DetectCycleUndirectedGraphDFS obj =
                new DetectCycleUndirectedGraphDFS();

        int V = 5;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 1}
        };

        boolean result =
                obj.isCycle(V,
                            edges);

        System.out.println(
                "Cycle Present : "
                        + result);
    }
}