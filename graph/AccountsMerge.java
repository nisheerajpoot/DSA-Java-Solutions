package graph;

import java.util.*;

public class AccountsMerge {

    /*
     * ============================================================
     * Platform   : LeetCode
     * Problem    : 721. Accounts Merge
     * Pattern    : DSU + HashMap + Connected Components
     *
     * Approach:
     *
     * 1. Treat every account as a separate DSU node.
     *
     * 2. Use HashMap:
     *      email -> account index
     *
     * 3. If an email appears for the first time,
     *    store its account index.
     *
     * 4. If the same email appears in another account,
     *    union both account indices.
     *
     * 5. After all unions, every connected account belongs
     *    to the same DSU component.
     *
     * 6. Group emails according to their ultimate parent.
     *
     * 7. Sort emails and add the account name.
     *
     * Time Complexity:
     * O(N * α(N) + E log E)
     *
     * Space Complexity:
     * O(N + E)
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

    public List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        int n = accounts.size();

        DSU dsu = new DSU(n);

        // email -> account index
        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Connect accounts having common emails
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < accounts.get(i).size(); j++) {

                String email = accounts.get(i).get(j);

                if (!map.containsKey(email)) {

                    map.put(email, i);

                } else {

                    dsu.union(i, map.get(email));
                }
            }
        }

        // Step 2: Group emails according to their parent
        HashMap<Integer, List<String>> merged =
                new HashMap<>();

        for (String email : map.keySet()) {

            int parent = dsu.find(map.get(email));

            merged
                    .computeIfAbsent(parent, k -> new ArrayList<>())
                    .add(email);
        }

        // Step 3: Create final answer
        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry :
                merged.entrySet()) {

            List<String> emails = entry.getValue();

            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            int parent = entry.getKey();

            // Account name
            account.add(accounts.get(parent).get(0));

            // Sorted emails
            account.addAll(emails);

            ans.add(account);
        }

        return ans;
    }

    public static void main(String[] args) {

        AccountsMerge obj = new AccountsMerge();

        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList(
                "John",
                "johnsmith@mail.com",
                "john_newyork@mail.com"
        ));

        accounts.add(Arrays.asList(
                "John",
                "johnsmith@mail.com",
                "john00@mail.com"
        ));

        accounts.add(Arrays.asList(
                "Mary",
                "mary@mail.com"
        ));

        accounts.add(Arrays.asList(
                "John",
                "johnnybravo@mail.com"
        ));

        List<List<String>> result =
                obj.accountsMerge(accounts);

        System.out.println("Merged Accounts:");

        for (List<String> account : result) {
            System.out.println(account);
        }
    }
}