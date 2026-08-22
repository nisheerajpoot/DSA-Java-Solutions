package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {

    /*
      Platform : GeeksforGeeks

      Question : Topological Sort

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Create an adjacency list
        from the given edges.

      - Start DFS from every
        unvisited node.

      - Visit all neighbors first.

      - After visiting all neighbors,
        push the current node into
        the stack.

      - Finally, pop all elements
        from the stack.

      - The popping order gives the
        Topological Sort.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)

      (Adjacency List +
       Visited Array +
       Stack +
       Recursive Call Stack)
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

        int vist[] =
                new int[V];

        Stack<Integer> st =
                new Stack<Integer>();

        for (int i = 0;
             i < V;
             i++) {

            if (vist[i] == 0) {

                dfs(
                        i,
                        vist,
                        st,
                        adj);
            }
        }

        while (!st.isEmpty()) {

            ans.add(st.pop());
        }

        return ans;
    }

    public void dfs(
            int node,
            int vist[],
            Stack<Integer> st,
            ArrayList<ArrayList<Integer>> adj) {

        vist[node] = 1;

        for (int it : adj.get(node)) {

            if (vist[it] == 0) {

                dfs(
                        it,
                        vist,
                        st,
                        adj);
            }
        }

        st.push(node);
    }

    public static void main(String[] args) {

        TopologicalSortDFS obj =
                new TopologicalSortDFS();

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