package stack.simulation_with_stack;

import java.util.Stack;

public class CrawlerLogFolder {

    /*
      Platform : LeetCode
      Question : Crawler Log Folder
      Pattern  : Simulation With Stack

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public int minOperations(String[] logs) {

        Stack<String> st = new Stack<>();

        for (String log : logs) {

            if (log.equals("../")) {

                if (!st.isEmpty()) {
                    st.pop();
                }
            }
            else if (log.equals("./")) {
                continue;
            }
            else {
                st.push(log);
            }
        }

        return st.size();
    }

    public static void main(String[] args) {

        CrawlerLogFolder obj = new CrawlerLogFolder();

        String[] logs = {"d1/","d2/","../","d21/","./"};

        System.out.println(obj.minOperations(logs));
    }
}