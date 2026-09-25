import java.util.*;

class Solution {

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

        int find(int node) {
            if (parent[node] == node) {
                return node;
            }

            return parent[node] = find(parent[node]);
        }

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
}