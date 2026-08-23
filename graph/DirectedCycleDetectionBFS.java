package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedCycleDetectionBFS {

    /*
      Platform : GeeksforGeeks

      Question : Detect Cycle in a Directed Graph

      Pattern  : Topological Sort

      Approach :
      Breadth First Search (BFS)

      Algorithm :
      Kahn's Algorithm

      Idea :
      - Create an adjacency list
        from the given directed edges.

      - Calculate the indegree of
        every node.

      - Add all nodes having
        indegree 0 into the queue.

      - Process nodes using BFS.

      - For every processed node,
        reduce the indegree of its
        adjacent nodes.

      - If an adjacent node gets
        indegree 0, add it to queue.

      - Count how many nodes are
        processed.

      - If count == V, then all nodes
        are processed and there is
        no cycle.

      - If count < V, some nodes
        could not be processed
        because of a cycle.

      Therefore:

      count == V  → No Cycle
      count < V   → Cycle Exists

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)

      (Adjacency List +
       Indegree Array +
       Queue)
    */

    public boolean isCyclic(
            int V,
            int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0;
             i < V;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Add directed edges
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        // Calculate indegree
        int[] inDegree =
                new int[V];

        for (int i = 0;
             i < V;
             i++) {

            for (int neighbor : adj.get(i)) {

                inDegree[neighbor]++;
            }
        }

        // Add all nodes having
        // indegree = 0
        Queue<Integer> q =
                new LinkedList<>();

        for (int i = 0;
             i < V;
             i++) {

            if (inDegree[i] == 0) {

                q.add(i);
            }
        }

        // Count processed nodes
        int count = 0;

        // BFS / Kahn's Algorithm
        while (!q.isEmpty()) {

            int node = q.poll();

            count++;

            // Reduce indegree of
            // adjacent nodes
            for (int neighbor : adj.get(node)) {

                inDegree[neighbor]--;

                // If indegree becomes 0,
                // add it to queue
                if (inDegree[neighbor] == 0) {

                    q.add(neighbor);
                }
            }
        }

        // All nodes processed
        // means no cycle
        if (count == V) {

            return false;
        }

        // Some nodes were not processed
        // means cycle exists
        return true;
    }

    public static void main(String[] args) {

        DirectedCycleDetectionBFS obj =
                new DirectedCycleDetectionBFS();

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
                "Cycle Present : "
                        + result);
    }
}