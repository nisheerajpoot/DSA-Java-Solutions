package graph;

import java.util.ArrayList;

public class DFSTraversalOfGraph {

    /*
      Platform : GeeksforGeeks

      Question : DFS Traversal of Graph

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Start traversal from node 0.
      - Mark the current node as
        visited.
      - Add the current node to
        the answer.
      - Traverse all adjacent nodes.
      - If a neighbor is not visited,
        recursively perform DFS on it.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V)

      (Visited Array + Recursive
       Call Stack + Answer List)
    */

    ArrayList<Integer> ans =
            new ArrayList<>();

    public ArrayList<Integer> dfs(
            ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        boolean[] visited =new boolean[v];

        dfs(0,adj,visited);

        return ans;
    }

    public void dfs(
            int node,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

        visited[node] = true;

        ans.add(node);

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                dfs(neighbor,
                    adj,
                    visited);
            }
        }
    }

    public static void main(String[] args) {

        DFSTraversalOfGraph obj =
                new DFSTraversalOfGraph();

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

        ArrayList<Integer> result =obj.dfs(adj);

        System.out.println("DFS Traversal : " + result);
    }
}