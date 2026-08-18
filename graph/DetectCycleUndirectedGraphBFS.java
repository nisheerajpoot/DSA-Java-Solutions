package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedGraphBFS {

    /*
      Platform : GeeksforGeeks

      Question : Detect Cycle in an
                 Undirected Graph

      Pattern  : Graph Cycle Detection

      Approach :
      Breadth First Search (BFS)
      + Parent Tracking

      Idea :
      - Create an adjacency list
        from the given edges.
      - Traverse every node because
        the graph may be disconnected.
      - For each unvisited node,
        start BFS.
      - Store both:
          {current node, parent node}
      - If a neighbor is not visited:
          - Mark it visited.
          - Add it to the queue.
          - Set current node as
            its parent.
      - If a neighbor is already
        visited and it is not the
        parent, a cycle exists.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)

      (Adjacency List +
       Visited Array + Queue)
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

                if (bfs(node,
                        adj,
                        visited)) {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean bfs(
            int start,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

        Queue<int[]> queue =
                new LinkedList<>();

        // {node, parent}
        queue.offer(
                new int[]{start, -1});

        visited[start] = true;

        while (!queue.isEmpty()) {

            int[] current =
                    queue.poll();

            int node =
                    current[0];

            int parent =
                    current[1];

            for (int neighbor :
                    adj.get(node)) {

                // Not visited
                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    // neighbor ka parent
                    // = current node
                    queue.offer(
                            new int[]{
                                    neighbor,
                                    node
                            });
                }

                // Already visited
                // but not parent
                else if (neighbor != parent) {

                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        DetectCycleUndirectedGraphBFS obj =
                new DetectCycleUndirectedGraphBFS();

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