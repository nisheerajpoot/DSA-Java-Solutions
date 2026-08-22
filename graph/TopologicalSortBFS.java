package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {

    /*
      Platform : GeeksforGeeks

      Question : Topological Sort

      Pattern  : Graph Traversal

      Approach :
      Breadth First Search (BFS)

      Algorithm :
      Kahn's Algorithm

      Idea :
      - Create an adjacency list
        from the given edges.

      - Calculate the indegree of
        every node.

      - Add all nodes with
        indegree 0 into the queue.

      - Remove nodes from the queue.

      - Add the removed node to
        the answer.

      - Reduce the indegree of all
        its adjacent nodes.

      - If any adjacent node gets
        indegree 0, add it to the
        queue.

      - Continue until the queue
        becomes empty.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)

      (Adjacency List +
       Indegree Array +
       Queue)
    */

    public ArrayList<Integer> topoSort(
            int V,
            int[][] edges) {

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        ArrayList<Integer> ans =
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

        int[] inDegree =
                new int[V];

        for (int i = 0;
             i < V;
             i++) {

            for (int it : adj.get(i)) {

                inDegree[it]++;
            }
        }

        Queue<Integer> q =
                new LinkedList<Integer>();

        for (int i = 0;
             i < V;
             i++) {

            if (inDegree[i] == 0) {

                q.add(i);
            }
        }

        while (!q.isEmpty()) {

            int node = q.peek();

            q.remove();

            ans.add(node);

            for (int it : adj.get(node)) {

                inDegree[it]--;

                if (inDegree[it] == 0) {

                    q.add(it);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        TopologicalSortBFS obj =
                new TopologicalSortBFS();

        int V = 6;

        int[][] edges = {
                {5, 2},
                {5, 0},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1}
        };

        ArrayList<Integer> result =
                obj.topoSort(V, edges);

        System.out.println(
                "Topological Sort : "
                        + result);
    }
}