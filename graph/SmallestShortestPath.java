package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestShortestPath {

    /*
      Platform : GeeksforGeeks

      Question : Shortest Path with Lexicographically Smallest Path

      Pattern  : Shortest Path

      Approach : Dijkstra using PriorityQueue

      Idea :
      - Create a weighted adjacency list.
      - Run Dijkstra from destination.
      - dist[node] stores the shortest distance
        from node to destination.
      - Start building the path from source.
      - At every node, choose the smallest neighbor
        which lies on a shortest path.

      Shortest Path Condition :
      dist[node] == weight + dist[neighbor]

      Lexicographical Condition :
      Choose the smallest valid neighbor.

      Time Complexity :
      O((V + E) log V + E)

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

    public ArrayList<Integer> shortestPath(
            int V,
            int[][] edges,
            int src,
            int dest) {

        ArrayList<ArrayList<Pair>> adj =
                new ArrayList<>();

        // Create adjacency list
        for (int i = 0;
             i <= V;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Add weighted edges
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(
                    new Pair(v, wt));

            adj.get(v).add(
                    new Pair(u, wt));
        }

        // Distance array
        int[] dist =
                new int[V + 1];

        Arrays.fill(
                dist,
                Integer.MAX_VALUE);

        // Start Dijkstra from destination
        dist[dest] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                Integer.compare(
                                        a.distance,
                                        b.distance));

        pq.offer(
                new Pair(dest, 0));

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

        // Destination unreachable
        if (dist[src] ==
                Integer.MAX_VALUE) {

            ArrayList<Integer> result =
                    new ArrayList<>();

            result.add(-1);

            return result;
        }

        // Build lexicographically
        // smallest shortest path
        ArrayList<Integer> path =
                new ArrayList<>();

        int node = src;

        path.add(node);

        while (node != dest) {

            int nextNode = -1;

            // Find smallest neighbor
            // that belongs to shortest path
            for (Pair next :
                    adj.get(node)) {

                int neighbor =
                        next.node;

                int weight =
                        next.distance;

                if (dist[node] ==
                        weight +
                        dist[neighbor]) {

                    if (nextNode == -1 ||
                            neighbor < nextNode) {

                        nextNode =
                                neighbor;
                    }
                }
            }

            node = nextNode;

            path.add(node);
        }

        return path;
    }

    public static void main(String[] args) {

        SmallestShortestPath obj =
                new SmallestShortestPath();

        int V = 5;

        int[][] edges = {
                {0, 1, 2},
                {0, 2, 2},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 1}
        };

        int src = 0;
        int dest = 4;

        ArrayList<Integer> result =
                obj.shortestPath(
                        V,
                        edges,
                        src,
                        dest);

        System.out.println(
                "Shortest Path : "
                        + result);
    }
}