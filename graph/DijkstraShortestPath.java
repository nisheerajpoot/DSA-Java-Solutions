package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

    /*
      Platform : GeeksforGeeks

      Question : Dijkstra Algorithm

      Pattern  : Shortest Path

      Approach : Dijkstra using PriorityQueue

      Idea :
      - Create a weighted adjacency list.
      - Initialize distance of every node as infinity.
      - Source node distance = 0.
      - Use PriorityQueue to always process
        the node having minimum distance.
      - For every neighbor, calculate the
        new possible distance.
      - If the new distance is smaller,
        update the distance and add it
        to the priority queue.

      Important :
      - Dijkstra works with non-negative weights.

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

    public ArrayList<Integer> dijkstra(
            int V,
            int[][] edges,
            int src) {

        ArrayList<ArrayList<Pair>> adj =
                new ArrayList<>();

        // Create adjacency list
        for (int i = 0;
             i < V;
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
        ArrayList<Integer> dist =
                new ArrayList<>();

        for (int i = 0;
             i < V;
             i++) {

            dist.add(Integer.MAX_VALUE);
        }

        dist.set(src, 0);

        // Min Heap
        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                Integer.compare(
                                        a.distance,
                                        b.distance));

        // Source
        pq.offer(
                new Pair(src, 0));

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
                    dist.get(node)) {

                continue;
            }

            // Check neighbors
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
                        dist.get(nextNode)) {

                    dist.set(
                            nextNode,
                            newDistance);

                    pq.offer(
                            new Pair(
                                    nextNode,
                                    newDistance));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        DijkstraShortestPath obj =
                new DijkstraShortestPath();

        int V = 5;

        int[][] edges = {
                {0, 1, 4},
                {0, 2, 1},
                {2, 1, 2},
                {1, 3, 1},
                {2, 3, 5},
                {3, 4, 3}
        };

        int src = 0;

        ArrayList<Integer> result =
                obj.dijkstra(
                        V,
                        edges,
                        src);

        System.out.println(
                "Shortest Distances : "
                        + result);
    }
}