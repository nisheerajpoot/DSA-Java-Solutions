
package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartiteBFS {

    /*
      Platform : LeetCode

      Question : Is Graph Bipartite?

      Pattern  : Graph Traversal

      Approach :
      Breadth First Search (BFS)

      Idea :
      - Use a color array to store
        the color of every node.
      - Initially, all nodes have
        color -1, meaning uncolored.
      - Start BFS from every
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

      (Color Array + Queue)
    */

    public boolean isBipartiteBFS(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        Arrays.fill(color, -1);

        Queue<Integer> queue =
                new LinkedList<>();

        for (int start = 0;
             start < n;
             start++) {

            if (color[start] != -1) {
                continue;
            }

            color[start] = 0;

            queue.offer(start);

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int neighbor : graph[node]) {

                    if (color[neighbor] == -1) {

                        color[neighbor] =
                                1 - color[node];

                        queue.offer(neighbor);
                    }

                    else if (color[neighbor]
                            == color[node]) {

                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        IsGraphBipartiteBFS obj =
                new IsGraphBipartiteBFS();

        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        boolean result =
                obj.isBipartiteBFS(graph);

        System.out.println(
                "Is Graph Bipartite : "
                        + result);
    }
}
