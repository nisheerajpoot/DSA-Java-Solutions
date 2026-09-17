package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    /*
     * ============================================================
     * Platform   : GeeksforGeeks
     * Problem    : Minimum Spanning Tree
     * Pattern    : Prim's Algorithm + PriorityQueue
     *
     * Approach:
     * 1. Create an undirected adjacency list.
     * 2. Start from node 0 with weight 0.
     * 3. Use a PriorityQueue to select the minimum-weight edge.
     * 4. If the node is already visited, skip it.
     * 5. Otherwise, include the node in the MST and add its weight.
     * 6. Add all unvisited adjacent nodes to the PriorityQueue.
     *
     * Time Complexity  : O(E log E)
     * Space Complexity : O(V + E)
     * ============================================================
     */

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int spanningTree(int V, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        boolean[] visited = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.weight, b.weight)
        );

        pq.offer(new Pair(0, 0));

        int mstWeight = 0;

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int weight = current.weight;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            mstWeight += weight;

            for (Pair next : adj.get(node)) {

                int nextNode = next.node;
                int nextWeight = next.weight;

                if (!visited[nextNode]) {
                    pq.offer(new Pair(nextNode, nextWeight));
                }
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {

        PrimsAlgorithm obj = new PrimsAlgorithm();

        int V = 4;

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 6},
                {0, 3, 5},
                {1, 3, 15},
                {2, 3, 4}
        };

        int result = obj.spanningTree(V, edges);

        System.out.println("Minimum Spanning Tree Weight: " + result);
    }
}