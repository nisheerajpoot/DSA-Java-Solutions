package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    /*
      Platform : LeetCode

      Question : Cheapest Flights Within K Stops

      Pattern  : Shortest Path with Stops

      Approach : BFS + Distance Array

      Idea :
      - Create a directed weighted adjacency list.
      - Queue mein city, cost aur stops store karenge.
      - Source city se BFS start karenge.
      - Har flight par jaakar new cost calculate karenge.
      - Agar new cost kam hai, distance update karenge.
      - K stops se zyada hone par further processing
        nahi karenge.
      - Destination ki minimum cost return karenge.
      - Agar destination unreachable hai,
        return -1.

      Important :
      - Flights directed hain.
      - Stops ka limit maintain karna important hai.

      Time Complexity :
      O(K * E)

      Space Complexity :
      O(V + E)
    */

    static class Pair {

        int city;
        int cost;
        int stops;

        Pair(int city, int cost, int stops) {

            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        ArrayList<ArrayList<Pair>> adj =
                new ArrayList<>();

        // Create adjacency list
        for (int i = 0;
             i < n;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Add directed flights
        for (int[] flight : flights) {

            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            adj.get(u).add(
                    new Pair(v, price, 0));
        }

        // Distance array
        int[] dist =
                new int[n];

        Arrays.fill(
                dist,
                Integer.MAX_VALUE);

        dist[src] = 0;

        // BFS Queue
        Queue<Pair> q =
                new LinkedList<>();

        q.offer(
                new Pair(
                        src,
                        0,
                        0));

        // BFS
        while (!q.isEmpty()) {

            Pair current =
                    q.poll();

            int city =
                    current.city;

            int cost =
                    current.cost;

            int stops =
                    current.stops;

            // Stops limit exceeded
            if (stops > k) {

                continue;
            }

            // Explore neighbors
            for (Pair next :
                    adj.get(city)) {

                int nextCity =
                        next.city;

                int price =
                        next.cost;

                int newCost =
                        cost + price;

                // Relaxation
                if (newCost <
                        dist[nextCity]) {

                    dist[nextCity] =
                            newCost;

                    q.offer(
                            new Pair(
                                    nextCity,
                                    newCost,
                                    stops + 1));
                }
            }
        }

        // Destination unreachable
        return dist[dst] ==
                Integer.MAX_VALUE
                ? -1
                : dist[dst];
    }

    public static void main(String[] args) {

        CheapestFlightsWithinKStops obj =
                new CheapestFlightsWithinKStops();

        int n = 4;

        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 3, 100},
                {0, 3, 500}
        };

        int src = 0;
        int dst = 3;
        int k = 2;

        int result =
                obj.findCheapestPrice(
                        n,
                        flights,
                        src,
                        dst,
                        k);

        System.out.println(
                "Cheapest Price : "
                        + result);
    }
}