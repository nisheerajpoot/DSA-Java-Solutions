package queue.basic_queue_simulation;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    /*
      Platform : LeetCode
      Question : Implement Stack using Queues
      Pattern  : Basic Queue Simulation

      Time Complexity :
      push()  -> O(n)
      pop()   -> O(1)
      top()   -> O(1)
      empty() -> O(1)

      Space Complexity : O(n)
    */

    Queue<Integer> q;

    public ImplementStackUsingQueues() {

        q = new LinkedList<>();
    }

    public void push(int x) {

        q.offer(x);

        int size = q.size();

        for (int i = 0; i < size - 1; i++) {

            q.offer(q.poll());
        }
    }

    public int pop() {

        return q.poll();
    }

    public int top() {

        return q.peek();
    }

    public boolean empty() {

        return q.isEmpty();
    }

    public static void main(String[] args) {

        ImplementStackUsingQueues obj =
                new ImplementStackUsingQueues();

        obj.push(10);
        obj.push(20);
        obj.push(30);

        System.out.println("Top element: " + obj.top());

        System.out.println("Popped element: " + obj.pop());

        System.out.println("Top after pop: " + obj.top());

        System.out.println("Is stack empty? " + obj.empty());
    }
}