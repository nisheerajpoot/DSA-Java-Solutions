package graph;

import java.util.*;

public class CriticalConnections {

    /*
     * ============================================================
     * Platform  : LeetCode
     * Problem   : 1192. Critical Connections in a Network
     * Pattern   : Tarjan's Algorithm / Bridges in Graph
     *
     * Approach:
     * 1. Create an undirected adjacency list.
     * 2. Use DFS to assign:
     *      tin[node] = discovery time of node
     *      low[node] = lowest discovery time reachable from node
     *
     * 3. For every DFS child:
     *
     *      low[child] > tin[node]
     *
     *    means there is no alternative path from child's subtree
     *    back to node or any ancestor of node.
     *
     *    Therefore, (node, child) is a bridge.
     *
     * Time Complexity : O(V + E)
     * Space Complexity: O(V + E)
     * ============================================================
     */

    int time = 0;

    public List<List<Integer>> criticalConnections(
            int n,
            List<List<Integer>> connections) {

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (List<Integer> edge : connections) {

            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Discovery time and lowest reachable time
        int[] tin = new int[n];
        int[] low = new int[n];

        Arrays.fill(tin, -1);

        List<List<Integer>> bridges = new ArrayList<>();

        // Graph can be disconnected
        for (int i = 0; i < n; i++) {

            if (tin[i] == -1) {
                dfs(i, -1, adj, tin, low, bridges);
            }
        }

        return bridges;
    }

    // DFS using Tarjan's Algorithm
    void dfs(
            int node,
            int parent,
            ArrayList<ArrayList<Integer>> adj,
            int[] tin,
            int[] low,
            List<List<Integer>> bridges) {

        // Discovery time
        tin[node] = low[node] = time++;

        for (int neighbour : adj.get(node)) {

            // Ignore the edge through which we came
            if (neighbour == parent) {
                continue;
            }

            // Unvisited neighbour
            if (tin[neighbour] == -1) {

                dfs(
                        neighbour,
                        node,
                        adj,
                        tin,
                        low,
                        bridges
                );

                // Update low after DFS
                low[node] = Math.min(
                        low[node],
                        low[neighbour]
                );

                // Bridge condition
                if (low[neighbour] > tin[node]) {

                    bridges.add(
                            Arrays.asList(node, neighbour)
                    );
                }

            } else {

                // Back edge
                low[node] = Math.min(
                        low[node],
                        tin[neighbour]
                );
            }
        }
    }

    // Main method for VS Code testing
    public static void main(String[] args) {

        int n = 4;

        List<List<Integer>> connections = new ArrayList<>();

        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        CriticalConnections obj = new CriticalConnections();

        List<List<Integer>> result =
                obj.criticalConnections(n, connections);

        System.out.println("Critical Connections: " + result);
    }
}