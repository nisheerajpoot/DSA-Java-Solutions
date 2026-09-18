package graph;

import java.util.ArrayList;

public class DisjointSetUnion {

    /*
     * ============================================================
     * Problem    : Disjoint Set Union (DSU)
     * Pattern    : Union by Size + Path Compression
     *
     * Approach:
     * 1. Each node initially belongs to its own set.
     * 2. find() returns the ultimate parent of a node.
     * 3. Path compression makes future find operations faster.
     * 4. union() combines two sets using their sizes.
     * 5. Type 1 query performs union(u, v).
     * 6. Type 2 query finds and stores the ultimate parent of u.
     *
     * Time Complexity:
     * Nearly O(1) per operation, O(alpha(N)) amortized.
     *
     * Space Complexity: O(N)
     * ============================================================
     */

    static class DSU {

        int[] parent;
        int[] size;

        DSU(int n) {

            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
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

    public ArrayList<Integer> DSU(int n, int[][] queries) {

        DSU dsu = new DSU(n);

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] query : queries) {

            int type = query[0];
            int u = query[1];
            int v = query[2];

            if (type == 1) {

                // Union u and v
                dsu.union(u, v);

            } else if (type == 2) {

                // Find ultimate parent of u
                result.add(dsu.find(u));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        DisjointSetUnion obj = new DisjointSetUnion();

        int n = 5;

        int[][] queries = {
                {1, 1, 2},
                {1, 2, 3},
                {2, 3, 0},
                {1, 4, 5},
                {2, 5, 0},
                {2, 1, 0}
        };

        ArrayList<Integer> result = obj.DSU(n, queries);

        System.out.println("Ultimate Parents: " + result);
    }
}