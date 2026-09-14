package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    /*
      Platform : LeetCode

      Question : Network Delay Time

      Pattern  : Shortest Path

      Approach : Dijkstra using PriorityQueue

      Idea :
      - Create a directed weighted adjacency list.
      - Start Dijkstra from node k.
      - dist[node] stores the shortest time
        required to reach that node from k.
      - Use PriorityQueue to process the node
        having minimum distance.
      - Relax all outgoing edges.
      - After Dijkstra, find the maximum
        shortest distance among all nodes.
      - If any node is unreachable,
        return -1.

      Important :
      - Graph is directed.
      - Node numbering starts from 1.
      - Answer is the maximum shortest distance.

      Time Complexity :
      O((V + E) log V)

      Space Complexity :
      O(V + E)
    */

    static class Pair {

        int node;
        int distance;

        Pair(int node, int distance) {

            this.node = node;
            this.distance = distance;
        }
    }

    public int networkDelayTime(
            int[][] times,
            int n,
            int k) {

        ArrayList<ArrayList<Pair>> adj =
                new ArrayList<>();

        // Create adjacency list
        for (int i = 0;
             i <= n;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Add directed weighted edges
        for (int[] time : times) {

            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(
                    new Pair(v, wt));
        }

        // Distance array
        int[] dist =
                new int[n + 1];

        Arrays.fill(
                dist,
                Integer.MAX_VALUE);

        // Min Heap
        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                Integer.compare(
                                        a.distance,
                                        b.distance));

        // Source
        dist[k] = 0;

        pq.offer(
                new Pair(k, 0));

        // Dijkstra
        while (!pq.isEmpty()) {

            Pair current =
                    pq.poll();

            int node =
                    current.node;

            int distance =
                    current.distance;

            // Ignore outdated distance
            if (distance >
                    dist[node]) {

                continue;
            }

            // Explore neighbors
            for (Pair next :
                    adj.get(node)) {

                int nextNode =
                        next.node;

                int weight =
                        next.distance;

                int newDistance =
                        distance + weight;

                // Relaxation
                if (newDistance <
                        dist[nextNode]) {

                    dist[nextNode] =
                            newDistance;

                    pq.offer(
                            new Pair(
                                    nextNode,
                                    newDistance));
                }
            }
        }

        // Find maximum shortest distance
        int ans = 0;

        for (int i = 1;
             i <= n;
             i++) {

            // Node unreachable
            if (dist[i] ==
                    Integer.MAX_VALUE) {

                return -1;
            }

            ans =
                    Math.max(
                            ans,
                            dist[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        NetworkDelayTime obj =
                new NetworkDelayTime();

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        int n = 4;

        int k = 2;

        int result =
                obj.networkDelayTime(
                        times,
                        n,
                        k);

        System.out.println(
                "Network Delay Time : "
                        + result);
    }
}