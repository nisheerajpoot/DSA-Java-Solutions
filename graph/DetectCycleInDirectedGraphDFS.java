package graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphDFS {

    /*
      Platform : GeeksforGeeks

      Question : Detect Cycle in a
                 Directed Graph

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Create an adjacency list
        from the given edges.

      - Use two arrays:
          * vist
            To track visited nodes.

          * PathVist
            To track nodes in the
            current DFS path.

      - Start DFS from every
        unvisited node.

      - If we visit a node that is
        already present in the
        current DFS path, a cycle
        exists.

      - After completing DFS for
        a node, remove it from the
        current DFS path.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)

      (Adjacency List +
       Visited Arrays +
       Recursive Call Stack)
    */

    public boolean isCyclic(
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
        }

        int vist[] =
                new int[V];

        int PathVist[] =
                new int[V];

        for (int i = 0;
             i < V;
             i++) {

            if (vist[i] == 0) {

                if (dfs(
                        i,
                        adj,
                        vist,
                        PathVist) == true) {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(
            int node,
            ArrayList<ArrayList<Integer>> adj,
            int vist[],
            int PathVist[]) {

        vist[node] = 1;

        PathVist[node] = 1;

        for (int it : adj.get(node)) {

            if (vist[it] == 0) {

                if (dfs(
                        it,
                        adj,
                        vist,
                        PathVist) == true) {

                    return true;
                }
            }

            else if (PathVist[it] == 1) {

                return true;
            }
        }

        PathVist[node] = 0;

        return false;
    }

    public static void main(String[] args) {

        DetectCycleInDirectedGraphDFS obj =
                new DetectCycleInDirectedGraphDFS();

        int V = 4;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 1}
        };

        boolean result =
                obj.isCyclic(V, edges);

        System.out.println(
                "Does Directed Graph "
                        + "Contain Cycle : "
                        + result);
    }
}