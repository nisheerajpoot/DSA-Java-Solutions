package graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    /*
      Platform : LeetCode

      Question : Find Eventual Safe States

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Use three arrays:

          * vist
            To track visited nodes.

          * PathVist
            To track nodes in the
            current DFS path.

          * check
            To mark safe nodes.

      - Start DFS from every
        unvisited node.

      - If a node is found again
        in the current DFS path,
        a cycle exists.

      - After successfully exploring
        all neighbors, mark the node
        as safe.

      - Finally, add all nodes with
        check[i] == 1 to the answer.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V)

      (Visited Arrays +
       Recursive Call Stack)
    */

    public List<Integer> eventualSafeNodes(
            int[][] graph) {

        int V =
                graph.length;

        int vist[] =
                new int[V];

        int PathVist[] =
                new int[V];

        int check[] =
                new int[V];

        for (int i = 0;
             i < V;
             i++) {

            if (vist[i] == 0) {

                dfs(
                        i,
                        graph,
                        vist,
                        PathVist,
                        check);
            }
        }

        List<Integer> safe =
                new ArrayList<>();

        for (int i = 0;
             i < V;
             i++) {

            if (check[i] == 1) {

                safe.add(i);
            }
        }

        return safe;
    }

    public boolean dfs(
            int node,
            int[][] graph,
            int vist[],
            int PathVist[],
            int check[]) {

        vist[node] = 1;

        PathVist[node] = 1;

        check[node] = 0;

        for (int it : graph[node]) {

            if (vist[it] == 0) {

                if (dfs(
                        it,
                        graph,
                        vist,
                        PathVist,
                        check) == true) {

                    return true;
                }
            }

            else if (PathVist[it] == 1) {

                return true;
            }
        }

        check[node] = 1;

        PathVist[node] = 0;

        return false;
    }

    public static void main(String[] args) {

        FindEventualSafeStates obj =
                new FindEventualSafeStates();

        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<Integer> result =
                obj.eventualSafeNodes(graph);

        System.out.println(
                "Eventual Safe Nodes : "
                        + result);
    }
}