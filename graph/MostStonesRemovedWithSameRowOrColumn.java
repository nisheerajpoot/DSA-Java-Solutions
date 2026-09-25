package graph;

import java.util.HashSet;

public class MostStonesRemovedWithSameRowOrColumn {

    /*
     * ============================================================
     * Platform   : LeetCode
     * Problem    : 947. Most Stones Removed with Same Row or Column
     * Pattern    : DSU + Connected Components
     *
     * Approach:
     *
     * 1. Treat every row and column as a DSU node.
     *
     * 2. For every stone at (row, col):
     *
     *      rowNode = row
     *      colNode = col + 10001
     *
     *    The offset makes row and column nodes different.
     *
     * 3. Union the row node and column node.
     *
     * 4. Count the number of connected components.
     *
     * 5. In every connected component, all stones except
     *    one can be removed.
     *
     * Therefore:
     *
     *      Maximum removable stones
     *      = Total stones - Connected Components
     *
     * Time Complexity : O(N * α(N))
     * Space Complexity: O(N)
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

        // Find ultimate parent using path compression
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

    public int removeStones(int[][] stones) {

        int n = stones.length;

        // Row and column nodes
        // Maximum coordinate is 10^4
        DSU dsu = new DSU(20005);

        HashSet<Integer> nodes = new HashSet<>();

        for (int[] stone : stones) {

            int row = stone[0];
            int col = stone[1];

            // Offset columns so row and column
            // don't have the same node number
            int rowNode = row;
            int colNode = col + 10001;

            dsu.union(rowNode, colNode);

            nodes.add(rowNode);
            nodes.add(colNode);
        }

        // Count connected components
        int components = 0;

        for (int node : nodes) {

            if (dsu.find(node) == node) {
                components++;
            }
        }

        return n - components;
    }

    public static void main(String[] args) {

        MostStonesRemovedWithSameRowOrColumn obj =
                new MostStonesRemovedWithSameRowOrColumn();

        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        int result = obj.removeStones(stones);

        System.out.println("Maximum Stones Removed: " + result);
    }
}