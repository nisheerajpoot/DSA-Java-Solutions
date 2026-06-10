package queue.sliding_window_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StreamFirstNonRepeating {

    public static String firstNonRepeating(String s) {

        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            freq[ch - 'a']++;
            q.offer(ch);

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            if (q.isEmpty()) {
                ans.append('#');
            } else {
                ans.append(q.peek());
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String s = "aabc";

        String result = firstNonRepeating(s);

        System.out.println(result);
    }
}