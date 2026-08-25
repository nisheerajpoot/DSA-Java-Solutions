package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeNodesBFS {

    /*
      Platform : LeetCode

      Question : Find Eventual Safe States

      Pattern  : Topological Sort

      Approach :
      Breadth First Search (BFS)

      Algorithm :
      Kahn's Algorithm + Reverse Graph

      Idea :
      - Original graph mein:
        graph[i] contains all nodes
        reachable from node i.

      - Terminal node ki outdegree 0 hoti hai.

      - Kahn's Algorithm mein
        indegree 0 nodes process karte hain.

      - Isliye graph ko reverse kar do.

        Original:
        u → v

        Reverse:
        v → u

      - Ab original terminal nodes
        reverse graph mein indegree 0
        nodes ban jayenge.

      - Unhe queue mein add karo.

      - BFS ke during unke previous
        nodes ka indegree reduce karo.

      - Jab kisi node ka indegree 0
        ho jaye, woh safe node hai.

      - Finally safe nodes ko sort karo,
        because answer increasing order
        mein required hai.

      Time Complexity :
      O(V + E + V log V)

      Space Complexity :
      O(V + E)

      (Reverse Adjacency List +
       Indegree Array +
       Queue +
       Answer List)
    */

    public List<Integer> eventualSafeNodes(
            int[][] graph) {

        int n = graph.length;

        // Reverse adjacency list
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        // Queue for terminal nodes
        Queue<Integer> q =
                new LinkedList<>();

        // Store safe nodes
        List<Integer> ans =
                new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0;
             i < n;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Create reverse graph
        for (int i = 0;
             i < n;
             i++) {

            for (int v : graph[i]) {

                // Original:
                // i → v

                // Reverse:
                // v → i
                adj.get(v).add(i);
            }
        }

        // Calculate indegree
        int[] indeg =
                new int[n];

        for (int i = 0;
             i < n;
             i++) {

            for (int neighbor : adj.get(i)) {

                indeg[neighbor]++;
            }
        }

        // Terminal nodes have
        // indegree 0 in reverse graph
        for (int i = 0;
             i < n;
             i++) {

            if (indeg[i] == 0) {

                q.offer(i);
            }
        }

        // BFS / Kahn's Algorithm
        while (!q.isEmpty()) {

            int node = q.poll();

            // Node is safe
            ans.add(node);

            // Process reverse neighbors
            for (int neighbor : adj.get(node)) {

                indeg[neighbor]--;

                // If indegree becomes 0,
                // node becomes safe
                if (indeg[neighbor] == 0) {

                    q.offer(neighbor);
                }
            }
        }

        // Required output is sorted
        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

        EventualSafeNodesBFS obj =
                new EventualSafeNodesBFS();

        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<Integer> result =
                obj.eventualSafeNodes(graph);

        System.out.println(
                "Eventual Safe Nodes : "
                        + result);
    }
}