package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {

    /*
      Platform : LeetCode

      Question : Number of Ways to Arrive at Destination

      Pattern  : Shortest Path + Counting Paths

      Approach : Dijkstra + Ways Array

      Idea :
      - Create a weighted undirected adjacency list.
      - Use Dijkstra to find the shortest distance
        from source node 0 to every node.
      - dist[node] stores the shortest distance
        to reach that node.
      - ways[node] stores the number of shortest
        ways to reach that node.
      - Initially:
            dist[0] = 0
            ways[0] = 1
      - If a shorter path is found:
            dist[nextNode] = newDistance
            ways[nextNode] = ways[node]
      - If another path with the same shortest
        distance is found:
            ways[nextNode] += ways[node]
      - Return the number of shortest ways to
        reach node n - 1.

      Important :
      - Use long for distance to avoid overflow.
      - Take ways modulo 1e9 + 7.

      Time Complexity :
      O((V + E) log V)

      Space Complexity :
      O(V + E)
    */

    static class Pair {

        int node;
        long distance;

        Pair(int node, long distance) {

            this.node = node;
            this.distance = distance;
        }
    }

    public int countPaths(
            int n,
            int[][] roads) {

        long MOD =
                1000000007;

        ArrayList<ArrayList<Pair>> adj =
                new ArrayList<>();

        // Create adjacency list
        for (int i = 0;
             i < n;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Add weighted undirected edges
        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(
                    new Pair(v, wt));

            adj.get(v).add(
                    new Pair(u, wt));
        }

        // Distance array
        long[] dist =
                new long[n];

        Arrays.fill(
                dist,
                Long.MAX_VALUE);

        // Number of shortest ways
        long[] ways =
                new long[n];

        // Min Heap
        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                Long.compare(
                                        a.distance,
                                        b.distance));

        // Source
        dist[0] = 0;

        ways[0] = 1;

        pq.offer(
                new Pair(0, 0));

        // Dijkstra
        while (!pq.isEmpty()) {

            Pair current =
                    pq.poll();

            int node =
                    current.node;

            long distance =
                    current.distance;

            // Ignore old/stale entry
            if (distance >
                    dist[node]) {

                continue;
            }

            // Explore neighbors
            for (Pair next :
                    adj.get(node)) {

                int nextNode =
                        next.node;

                long newDistance =
                        distance +
                        next.distance;

                // Found a shorter path
                if (newDistance <
                        dist[nextNode]) {

                    dist[nextNode] =
                            newDistance;

                    ways[nextNode] =
                            ways[node];

                    pq.offer(
                            new Pair(
                                    nextNode,
                                    newDistance));
                }

                // Found another shortest path
                else if (newDistance ==
                         dist[nextNode]) {

                    ways[nextNode] =
                            (ways[nextNode] +
                             ways[node]) % MOD;
                }
            }
        }

        // Number of shortest paths
        return (int) ways[n - 1];
    }

    public static void main(String[] args) {

        NumberOfWaysToArriveAtDestination obj =
                new NumberOfWaysToArriveAtDestination();

        int n = 7;

        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {1, 4, 2},
                {2, 5, 2},
                {3, 5, 1},
                {4, 6, 3},
                {5, 6, 1}
        };

        int result =
                obj.countPaths(
                        n,
                        roads);

        System.out.println(
                "Number of Shortest Ways : "
                        + result);
    }
}