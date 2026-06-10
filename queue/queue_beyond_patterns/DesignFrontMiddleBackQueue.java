package queue.queue_beyond_patterns;

import java.util.Deque;
import java.util.LinkedList;

public class DesignFrontMiddleBackQueue {

    /*
      Platform : LeetCode
      Question : Design Front Middle Back Queue


      Approach :
      Two Deques + Balancing

      Idea :
      - Maintain two halves:
        left  -> first half
        right -> second half

      - Keep:
        left.size() == right.size()
        OR
        left.size() == right.size() + 1

      - Middle element is always at the end of left deque.

      Time Complexity :
      pushFront()  -> O(1)
      pushMiddle() -> O(1)
      pushBack()   -> O(1)
      popFront()   -> O(1)
      popMiddle()  -> O(1)
      popBack()    -> O(1)

      Space Complexity :
      O(n)
    */

    Deque<Integer> left;
    Deque<Integer> right;

    public DesignFrontMiddleBackQueue() {

        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    private void balance() {

        if (left.size() > right.size() + 1) {
            right.offerFirst(left.pollLast());
        }

        if (left.size() < right.size()) {
            left.offerLast(right.pollFirst());
        }
    }

    public void pushFront(int val) {

        left.offerFirst(val);

        balance();
    }

    public void pushMiddle(int val) {

        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }

        left.offerLast(val);
    }

    public void pushBack(int val) {

        right.offerLast(val);

        balance();
    }

    public int popFront() {

        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int ans;

        if (!left.isEmpty()) {
            ans = left.pollFirst();
        }
        else {
            ans = right.pollFirst();
        }

        balance();

        return ans;
    }

    public int popMiddle() {

        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int ans = left.pollLast();

        balance();

        return ans;
    }

    public int popBack() {

        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int ans;

        if (!right.isEmpty()) {
            ans = right.pollLast();
        }
        else {
            ans = left.pollLast();
        }

        balance();

        return ans;
    }

    public static void main(String[] args) {

        DesignFrontMiddleBackQueue q =
                new DesignFrontMiddleBackQueue();

        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);

        System.out.println(q.popFront());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popBack());
        System.out.println(q.popFront());
    }
}