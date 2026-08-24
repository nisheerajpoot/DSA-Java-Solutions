package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    /*
      Platform : LeetCode

      Question : Course Schedule II

      Pattern  : Topological Sort

      Approach :
      Breadth First Search (BFS)

      Algorithm :
      Kahn's Algorithm

      Idea :
      - Courses ko directed graph ke
        form mein represent karo.

      - prerequisite [u, v] ka meaning:
        v ko pehle complete karna hai,
        uske baad u.

        Therefore:
        v → u

      - Har course ka indegree calculate karo.

      - Jinka indegree 0 hai,
        unhe queue mein add karo.

      - BFS perform karo.

      - Processed course ko answer
        array mein add karo.

      - Uske adjacent courses ka
        indegree decrease karo.

      - Agar indegree 0 ho jaye,
        course ko queue mein add karo.

      - Agar saare courses process ho
        gaye, valid ordering possible hai.

      - Agar saare courses process nahi
        hue, graph mein cycle hai.

      Time Complexity :
      O(V + E)

      Space Complexity :
      O(V + E)

      (Adjacency List +
       Indegree Array +
       Queue +
       Answer Array)
    */

    public int[] findOrder(
            int numCourses,
            int[][] prerequisites) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        // Queue for indegree 0 courses
        Queue<Integer> q =
                new LinkedList<>();

        // Answer array
        int[] ans =
                new int[numCourses];

        // Initialize adjacency list
        for (int i = 0;
             i < numCourses;
             i++) {

            adj.add(new ArrayList<>());
        }

        // Create directed edges
        for (int[] it : prerequisites) {

            int u = it[0];
            int v = it[1];

            // v must be completed
            // before u
            adj.get(v).add(u);
        }

        // Calculate indegree
        int[] indeg =
                new int[numCourses];

        for (int i = 0;
             i < numCourses;
             i++) {

            for (int neighbor : adj.get(i)) {

                indeg[neighbor]++;
            }
        }

        // Add courses having
        // indegree = 0
        for (int i = 0;
             i < numCourses;
             i++) {

            if (indeg[i] == 0) {

                q.offer(i);
            }
        }

        // Count processed courses
        int count = 0;

        // BFS / Kahn's Algorithm
        while (!q.isEmpty()) {

            int node = q.poll();

            // Store course in answer
            ans[count++] = node;

            // Process adjacent courses
            for (int neighbor : adj.get(node)) {

                indeg[neighbor]--;

                // If indegree becomes 0,
                // add it to queue
                if (indeg[neighbor] == 0) {

                    q.add(neighbor);
                }
            }
        }

        // If all courses are processed,
        // return valid ordering
        if (count == numCourses) {

            return ans;
        }

        // Cycle exists
        // Therefore ordering is impossible
        return new int[]{};
    }

    public static void main(String[] args) {

        CourseScheduleII obj =
                new CourseScheduleII();

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] result =obj.findOrder(numCourses, prerequisites);

        System.out.print(
                "Course Order : ");

        for (int course : result) {

            System.out.print(
                    course + " ");
        }
    }
}