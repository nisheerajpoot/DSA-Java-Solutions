package graph;

import java.util.Arrays;

public class KruskalsAlgorithm {

    /*
     * ============================================================
     * Platform   : GeeksforGeeks
     * Problem    : Minimum Spanning Tree
     * Pattern    : Kruskal's Algorithm + DSU
     *
     * Approach:
     * 1. Sort all edges according to their weights.
     * 2. Create a DSU using Path Compression and Union by Size.
     * 3. Pick the smallest edge that connects two different sets.
     * 4. Add its weight to the MST total.
     * 5. Stop after selecting V - 1 edges.
     *
     * Time Complexity  : O(E log E)
     * Space Complexity : O(V)
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

        // Find the ultimate parent with path compression
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

    public int spanningTree(int V, int[][] edges) {

        // Sort edges by increasing weight
        Arrays.sort(edges, (a, b) ->
                Integer.compare(a[2], b[2])
        );

        DSU dsu = new DSU(V);

        int mstWeight = 0;
        int edgeCount = 0;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            // Include the edge only if it does not form a cycle
            if (dsu.find(u) != dsu.find(v)) {

                mstWeight += wt;
                dsu.union(u, v);
                edgeCount++;

                if (edgeCount == V - 1) {
                    break;
                }
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {

        KruskalsAlgorithm obj = new KruskalsAlgorithm();

        int V = 4;

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 6},
                {0, 3, 5},
                {1, 3, 15},
                {2, 3, 4}
        };

        int result = obj.spanningTree(V, edges);

        System.out.println("Minimum Spanning Tree Weight: " + result);
    }
}