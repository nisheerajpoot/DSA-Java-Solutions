package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleBFS {

    /*
      Platform : GeeksforGeeks

      Question : Prerequisite Tasks

      Pattern  : Graph Traversal

      Approach :
      Breadth First Search (BFS)

      Algorithm :
      Kahn's Algorithm

      Idea :
      - Create an adjacency list
        using prerequisite edges.

      - Calculate the indegree of
        every task.

      - Add all tasks having
        indegree 0 into the queue.

      - Process tasks using BFS.

      - After processing a task,
        reduce the indegree of all
        its adjacent tasks.

      - If an adjacent task gets
        indegree 0, add it to
        the queue.

      - If all n tasks are processed,
        it means no cycle exists.

      - If all tasks cannot be
        processed, a cycle exists.

      - Therefore, all tasks can
        be completed only when:

        ans.size() == n

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)

      (Adjacency List +
       Indegree Array +
       Queue +
       Answer List)
    */

    public boolean isPossible(
            int n,
            int[][] pre) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        // Store topological order
        ArrayList<Integer> ans =
                new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0;
             i < n;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Add directed edges
        for (int[] it : pre) {

            int u = it[0];
            int v = it[1];

            adj.get(u).add(v);
        }

        // Calculate indegree
        int[] inDegree =
                new int[n];

        for (int i = 0;
             i < n;
             i++) {

            for (int it : adj.get(i)) {

                inDegree[it]++;
            }
        }

        // Add all nodes having
        // indegree = 0
        Queue<Integer> q =
                new LinkedList<>();

        for (int i = 0;
             i < n;
             i++) {

            if (inDegree[i] == 0) {

                q.add(i);
            }
        }

        // BFS / Kahn's Algorithm
        while (!q.isEmpty()) {

            int node = q.poll();

            // Add processed node
            // to topological order
            ans.add(node);

            // Reduce indegree of
            // adjacent nodes
            for (int it : adj.get(node)) {

                inDegree[it]--;

                // If indegree becomes 0,
                // add it to queue
                if (inDegree[it] == 0) {

                    q.add(it);
                }
            }
        }

        // If all nodes are processed,
        // graph does not contain a cycle
        if (ans.size() == n) {

            return true;
        }

        // Cycle exists
        return false;
    }

    public static void main(String[] args) {

        CourseScheduleBFS obj =
                new CourseScheduleBFS();

        int n = 4;

        int[][] pre = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        boolean result =
                obj.isPossible(n, pre);

        System.out.println("Is it possible to "
                + "complete all tasks? "
                + result);
    }
}