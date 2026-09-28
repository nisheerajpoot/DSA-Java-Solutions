package graph;

import java.util.*;

public class ArticulationPoint {

    /*
     * ============================================================
     * Platform  : GeeksforGeeks
     * Problem   : Articulation Point
     * Pattern   : Tarjan's Algorithm
     *
     * Approach:
     * 1. Create an undirected adjacency list.
     * 2. Perform DFS.
     * 3. For every node maintain:
     *
     *      tin[node] = discovery time of node
     *      low[node] = lowest discovery time reachable
     *                  from this node/subtree
     *
     * 4. A non-root node is an Articulation Point if:
     *
     *      low[child] >= tin[node]
     *
     * 5. For the DFS root:
     *
     *      children > 1
     *
     *    means the root is an Articulation Point.
     *
     * Time Complexity : O(V + E)
     * Space Complexity: O(V + E)
     * ============================================================
     */

    static int timer;

    static void dfs(
            int node,
            int parent,
            ArrayList<ArrayList<Integer>> adj,
            int[] tin,
            int[] low,
            boolean[] visited,
            boolean[] isAP) {

        visited[node] = true;

        // Discovery time
        tin[node] = low[node] = timer++;

        int children = 0;

        for (int neighbour : adj.get(node)) {

            // Ignore parent edge
            if (neighbour == parent) {
                continue;
            }

            // Unvisited neighbour
            if (!visited[neighbour]) {

                children++;

                dfs(
                        neighbour,
                        node,
                        adj,
                        tin,
                        low,
                        visited,
                        isAP
                );

                // Update low value
                low[node] = Math.min(
                        low[node],
                        low[neighbour]
                );

                // Articulation Point condition
                if (parent != -1 &&
                        low[neighbour] >= tin[node]) {

                    isAP[node] = true;
                }

            } else {

                // Back edge
                low[node] = Math.min(
                        low[node],
                        tin[neighbour]
                );
            }
        }

        // Special condition for DFS root
        if (parent == -1 && children > 1) {
            isAP[node] = true;
        }
    }

    static ArrayList<Integer> articulationPoints(
            int V,
            int[][] edges) {

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] tin = new int[V];
        int[] low = new int[V];

        boolean[] visited = new boolean[V];
        boolean[] isAP = new boolean[V];

        timer = 0;

        // Graph can be disconnected
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                dfs(
                        i,
                        -1,
                        adj,
                        tin,
                        low,
                        visited,
                        isAP
                );
            }
        }

        // Store articulation points
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            if (isAP[i]) {
                ans.add(i);
            }
        }

        // If no articulation point exists
        if (ans.isEmpty()) {
            ans.add(-1);
        }

        return ans;
    }

    // Main method for VS Code testing
    public static void main(String[] args) {

        int V = 5;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0},
                {1, 3},
                {3, 4}
        };

        ArrayList<Integer> result =
                articulationPoints(V, edges);

        System.out.println("Articulation Points: " + result);
    }
}