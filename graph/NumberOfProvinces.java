package graph;

public class NumberOfProvinces {

    /*
      Platform : LeetCode

      Question : Number of Provinces

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Each city is treated as
        a node in the graph.
      - Traverse all cities.
      - If a city is not visited,
        it represents a new province.
      - Increase the province count.
      - Use DFS to visit all
        directly and indirectly
        connected cities.
      - Mark every visited city
        so it is not counted again.

      Time Complexity :
      O(n * n)

      Space Complexity :
      O(n)

      (Visited Array +
       Recursive Call Stack)
    */

    public int findCircleNum(int[][] isConnected) {

        int n =
                isConnected.length;

        boolean[] visited =
                new boolean[n];

        int count = 0;

        for (int city = 0;
             city < n;
             city++) {

            if (!visited[city]) {

                count++;

                dfs(city,
                    isConnected,
                    visited);
            }
        }

        return count;
    }

    public void dfs(
            int city,
            int[][] isConnected,
            boolean[] visited) {

        visited[city] = true;

        for (int neighbor = 0;
             neighbor < isConnected.length;
             neighbor++) {

            if (isConnected[city][neighbor] == 1
                    && !visited[neighbor]) {

                dfs(neighbor,
                    isConnected,
                    visited);
            }
        }
    }

    public static void main(String[] args) {

        NumberOfProvinces obj =
                new NumberOfProvinces();

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int result =
                obj.findCircleNum(isConnected);

        System.out.println(
                "Number of Provinces : "
                        + result);
    }
}