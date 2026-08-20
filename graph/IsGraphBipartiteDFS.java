package graph;

import java.util.Arrays;

public class IsGraphBipartiteDFS {

    /*
      Platform : LeetCode

      Question : Is Graph Bipartite?

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Use a color array to store
        the color of every node.
      - Initially, all nodes have
        color -1, meaning uncolored.
      - Start DFS from every
        unvisited component.
      - Assign the starting node
        color 0.
      - Assign every neighbor the
        opposite color.
      - If two connected nodes have
        the same color, return false.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V)

      (Color Array +
       Recursive Call Stack)
    */

    int[] color;

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        color = new int[n];

        Arrays.fill(color, -1);

        for (int node = 0;
             node < n;
             node++) {

            if (color[node] == -1) {

                color[node] = 0;

                if (!dfs(node, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(
            int node,
            int[][] graph) {

        for (int neighbor : graph[node]) {

            if (color[neighbor] == -1) {

                color[neighbor] =
                        1 - color[node];

                if (!dfs(neighbor, graph)) {
                    return false;
                }
            }

            else if (color[neighbor]
                    == color[node]) {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        IsGraphBipartiteDFS obj =
                new IsGraphBipartiteDFS();

        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        boolean result =
                obj.isBipartite(graph);

        System.out.println(
                "Is Graph Bipartite : "
                        + result);
    }
}