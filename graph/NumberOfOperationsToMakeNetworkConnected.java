package graph;

public class NumberOfOperationsToMakeNetworkConnected {

    /*
     * ============================================================
     * Platform   : LeetCode
     * Problem    : 1319. Number of Operations to Make Network Connected
     * Pattern    : DSU + Connected Components
     *
     * Approach:
     * 1. If connections.length < n - 1, return -1 because
     *    at least n - 1 cables are required to connect n computers.
     * 2. Initially, there are n separate components.
     * 3. For every connection, check whether both computers
     *    belong to different components.
     * 4. If they belong to different components, union them
     *    and decrease the component count.
     * 5. The minimum operations required is components - 1.
     *
     * Time Complexity  : O(E × α(N))
     * Space Complexity : O(N)
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

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        DSU dsu = new DSU(n);

        int components = n;

        for (int[] connection : connections) {

            int u = connection[0];
            int v = connection[1];

            if (dsu.find(u) != dsu.find(v)) {

                dsu.union(u, v);
                components--;
            }
        }

        return components - 1;
    }

    public static void main(String[] args) {

        NumberOfOperationsToMakeNetworkConnected obj =new NumberOfOperationsToMakeNetworkConnected();

        int n = 4;

        int[][] connections = {
                {0, 1},
                {0, 2},
                {1, 2}
        };

        int result = obj.makeConnected(n, connections);

        System.out.println("Minimum Operations: " + result);
    }
}