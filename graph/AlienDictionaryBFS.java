package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionaryBFS {

    /*
      Platform : GeeksforGeeks

      Question : Alien Dictionary

      Pattern  : Topological Sort

      Approach : BFS

      Algorithm : Kahn's Algorithm

      Idea :
      - Given words are already sorted according
        to the alien language.

      - Compare every two adjacent words.

      - Find the first position where characters
        are different.

      - That gives us the ordering:
            ch1 -> ch2

      - Build a directed graph using these relations.

      - Calculate indegree of every character.

      - Add characters having indegree 0
        into the queue.

      - Apply Kahn's Algorithm.

      - If all present characters are processed,
        return the ordering.

      - Otherwise, there is a cycle.

      Time Complexity :
      O(N * L + K + E)

      N = number of words
      L = average word length
      K = number of characters
      E = number of edges

      Space Complexity :
      O(K + E)
    */

    public String findOrder(String[] words) {

        int K = 26;

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        for (int i = 0;
             i < K;
             i++) {

            adj.add(new ArrayList<>());
        }

        /*
          present[i] tells whether
          character i exists in the words.
        */
        boolean[] present =
                new boolean[K];

        for (String word : words) {

            for (char ch : word.toCharArray()) {

                present[ch - 'a'] = true;
            }
        }

        /*
          Build graph.

          Compare adjacent words.
        */
        for (int i = 0;
             i < words.length - 1;
             i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int len =
                    Math.min(
                            word1.length(),
                            word2.length());

            boolean found = false;

            for (int j = 0;
                 j < len;
                 j++) {

                char ch1 =
                        word1.charAt(j);

                char ch2 =
                        word2.charAt(j);

                if (ch1 != ch2) {

                    int u = ch1 - 'a';
                    int v = ch2 - 'a';

                    /*
                      First different character
                      determines the ordering.

                      ch1 -> ch2
                    */
                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                    }

                    found = true;

                    break;
                }
            }

            /*
              Invalid case:

              "abcd"
              "ab"

              Longer word cannot come before
              its prefix.
            */
            if (!found &&
                word1.length() > word2.length()) {

                return "";
            }
        }

        /*
          Calculate indegree.
        */
        int[] indegree =
                new int[K];

        for (int i = 0;
             i < K;
             i++) {

            for (int neighbor :
                    adj.get(i)) {

                indegree[neighbor]++;
            }
        }

        /*
          Kahn's Algorithm

          Add all characters having
          indegree = 0.
        */
        Queue<Integer> queue =
                new LinkedList<>();

        for (int i = 0;
             i < K;
             i++) {

            if (present[i] &&
                indegree[i] == 0) {

                queue.add(i);
            }
        }

        StringBuilder ans =
                new StringBuilder();

        /*
          BFS
        */
        while (!queue.isEmpty()) {

            int node =
                    queue.poll();

            ans.append(
                    (char) (node + 'a'));

            for (int neighbor :
                    adj.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {

                    queue.add(neighbor);
                }
            }
        }

        /*
          Count total characters
          present in the input.
        */
        int totalCharacters = 0;

        for (boolean exists :
                present) {

            if (exists) {
                totalCharacters++;
            }
        }

        /*
          If some characters were not processed,
          graph contains a cycle.
        */
        if (ans.length() != totalCharacters) {

            return "";
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        AlienDictionaryBFS obj =
                new AlienDictionaryBFS();

        String[] words = {
                "baa",
                "abcd",
                "abca",
                "cab",
                "cad"
        };

        String result =
                obj.findOrder(words);

        System.out.println(
                "Alien Dictionary Order : "
                        + result);
    }
}