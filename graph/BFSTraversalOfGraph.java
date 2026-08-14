package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalOfGraph {

    /*
      Platform : GeeksforGeeks

      Question : BFS Traversal of Graph

      Pattern  : Graph Traversal

      Approach :
      Breadth First Search (BFS)

      Idea :
      - Start traversal from node 0.
      - Mark node 0 as visited.
      - Add node 0 to the queue.
      - While the queue is not empty:
          1. Remove a node.
          2. Add it to the answer.
          3. Visit all its unvisited
             adjacent nodes.
          4. Mark them visited and
             add them to the queue.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V)

      (Visited Array + Queue)
    */

    public ArrayList<Integer> bfs(
            ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        ArrayList<Integer> ans =
                new ArrayList<>();

        boolean[] visited =
                new boolean[v];

        Queue<Integer> queue =
                new LinkedList<>();

        visited[0] = true;

        queue.offer(0);

        while (!queue.isEmpty()) {

            int node =
                    queue.poll();

            ans.add(node);

            for (int n : adj.get(node)) {

                if (!visited[n]) {

                    visited[n] = true;

                    queue.offer(n);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        BFSTraversalOfGraph obj =
                new BFSTraversalOfGraph();

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        int vertices = 5;

        for (int i = 0;
             i < vertices;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Add Edges
        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(0);

        adj.get(3).add(1);

        adj.get(4).add(1);

        ArrayList<Integer> result =
                obj.bfs(adj);

        System.out.println(
                "BFS Traversal : " + result);
    }
}