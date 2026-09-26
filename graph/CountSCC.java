package graph;

import java.util.*;

public class CountSCC {

    /*
     * ============================================================
     * Platform  : GFG
     * Problem   : Count Strongly Connected Components (SCC)
     * Pattern   : Kosaraju's Algorithm
     *
     * Approach:
     * 1. Create the original directed graph.
     * 2. Perform DFS on the original graph.
     *    Store each node in stack after DFS is completed.
     * 3. Create the reversed graph by reversing every edge.
     * 4. Reset visited array.
     * 5. Pop nodes from stack and perform DFS on reversed graph.
     * 6. Every DFS traversal gives one SCC.
     *
     * Time Complexity : O(V + E)
     * Space Complexity: O(V + E)
     * ============================================================
     */

    public static int countSCC(int V, int[][] edges) {

        // Step 1: Create original adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        // Step 2: DFS on original graph
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Step 3: Create reversed graph
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            reverse.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            reverse.get(v).add(u);
        }

        // Step 4: DFS on reversed graph
        Arrays.fill(visited, false);

        int count = 0;

        while (!stack.isEmpty()) {

            int node = stack.pop();

            if (!visited[node]) {

                dfsReverse(node, reverse, visited);

                // One DFS = One SCC
                count++;
            }
        }

        return count;
    }

    // DFS on original graph
    static void dfs(
            int node,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited,
            Stack<Integer> stack) {

        visited[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, stack);
            }
        }

        // Store node after DFS is completely finished
        stack.push(node);
    }

    // DFS on reversed graph
    static void dfsReverse(
            int node,
            ArrayList<ArrayList<Integer>> reverse,
            boolean[] visited) {

        visited[node] = true;

        for (int neighbour : reverse.get(node)) {

            if (!visited[neighbour]) {
                dfsReverse(neighbour, reverse, visited);
            }
        }
    }

    // Main method for VS Code testing
    public static void main(String[] args) {

        int V = 5;

        int[][] edges = {
                {1, 0},
                {0, 2},
                {2, 1},
                {0, 3},
                {3, 4}
        };

        int result = countSCC(V, edges);

        System.out.println("Number of SCCs: " + result);
    }
}