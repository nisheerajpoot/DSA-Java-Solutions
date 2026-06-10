package queue.basic_queue_simulation;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch {

    /*
      Platform : LeetCode
      Question : Number of Students Unable to Eat Lunch
      Approach :
      Queue Simulation

      Idea :
      - Students stand in a queue.
      - If front student likes the current sandwich,
        student takes it and leaves.
      - Otherwise move the student to the back.
      - If one complete rotation happens and no student
        takes the sandwich, the process stops.

      Time Complexity :
      O(n²)

      Space Complexity :
      O(n)
    */

    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> q = new LinkedList<>();

        for (int student : students) {
            q.offer(student);
        }

        int index = 0;
        int count = 0;

        while (!q.isEmpty()) {

            if (q.peek() == sandwiches[index]) {

                q.poll();
                index++;
                count = 0;
            }
            else {

                q.offer(q.poll());
                count++;
            }

            if (count == q.size()) {
                break;
            }
        }

        return q.size();
    }

    public static void main(String[] args) {

        NumberOfStudentsUnableToEatLunch obj =
                new NumberOfStudentsUnableToEatLunch();

        int[] students = {1, 1, 0, 0};

        int[] sandwiches = {0, 1, 0, 1};

        System.out.println(
                obj.countStudents(students, sandwiches)
        );
    }
}