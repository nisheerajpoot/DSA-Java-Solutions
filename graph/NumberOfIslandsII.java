package graph;

import java.util.ArrayList;

public class NumberOfIslandsII {

    /*
     * ============================================================
     * Platform   : GeeksforGeeks
     * Problem    : Number of Islands - II
     * Pattern    : DSU + Grid + Dynamic Connected Components
     *
     * Approach:
     *
     * 1. Initially, all cells are water.
     *
     * 2. Whenever an operator adds land:
     *      - Mark the cell as land.
     *      - Increase island count by 1.
     *
     * 3. Check all 4 neighbouring cells.
     *
     * 4. If a neighbouring cell is already land and belongs
     *    to a different DSU component:
     *      - Union both cells.
     *      - Decrease island count by 1.
     *
     * 5. If the cell is already land, do not process it again.
     *
     * Cell -> DSU node:
     *      node = row * m + col
     *
     * Time Complexity:
     * O(K * α(N*M))
     *
     * Space Complexity:
     * O(N*M)
     * ============================================================
     */

    static class DSU {

        int[] parent;
        int[] size;

        DSU(int n) {

            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // Find the ultimate parent using path compression
        int find(int node) {

            if (parent[node] == node) {
                return node;
            }

            return parent[node] = find(parent[node]);
        }

        // Union by size
        void union(int u, int v) {

            int parentU = find(u);
            int parentV = find(v);

            if (parentU == parentV) {
                return;
            }

            if (size[parentU] < size[parentV]) {

                parent[parentU] = parentV;
                size[parentV] += size[parentU];

            } else {

                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            }
        }
    }

    public ArrayList<Integer> numOfIslands(
            int n, int m, int[][] operators) {

        ArrayList<Integer> ans = new ArrayList<>();

        DSU dsu = new DSU(n * m);

        int[][] grid = new int[n][m];

        int islands = 0;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int[] op : operators) {

            int row = op[0];
            int col = op[1];

            // Cell is already land
            if (grid[row][col] == 1) {

                ans.add(islands);
                continue;
            }

            // Convert water into land
            grid[row][col] = 1;
            islands++;

            // Convert 2D cell into 1D DSU node
            int node = row * m + col;

            // Check all 4 neighbours
            for (int i = 0; i < 4; i++) {

                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // Out of bounds
                if (newRow < 0 || newRow >= n ||
                    newCol < 0 || newCol >= m) {

                    continue;
                }

                // Neighbour is water
                if (grid[newRow][newCol] == 0) {
                    continue;
                }

                int neighbour = newRow * m + newCol;

                // If they belong to different components,
                // merge them and decrease island count
                if (dsu.find(node) != dsu.find(neighbour)) {

                    dsu.union(node, neighbour);
                    islands--;
                }
            }

            ans.add(islands);
        }

        return ans;
    }

    public static void main(String[] args) {

        NumberOfIslandsII obj = new NumberOfIslandsII();

        int n = 4;
        int m = 5;

        int[][] operators = {
                {1, 1},
                {0, 1},
                {3, 3},
                {3, 4},
                {1, 2}
        };

        ArrayList<Integer> result =
                obj.numOfIslands(n, m, operators);

        System.out.println("Number of Islands: " + result);
    }
}