package queue.basic_queue_simulation;

public class DesignCircularQueue {

    /*
      Platform : LeetCode
      Question : Design Circular Queue
      Pattern  : Queue Simulation

      Time Complexity :
      enQueue() -> O(1)
      deQueue() -> O(1)
      Front()   -> O(1)
      Rear()    -> O(1)
      isEmpty() -> O(1)
      isFull()  -> O(1)

      Space Complexity : O(k)
    */

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    public DesignCircularQueue(int k) {

        capacity = k;
        queue = new int[k];

        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        return true;
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return queue[rear];
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public boolean isFull() {

        return size == capacity;
    }

    public static void main(String[] args) {

        DesignCircularQueue q = new DesignCircularQueue(3);

        System.out.println(q.enQueue(1));
        System.out.println(q.enQueue(2));
        System.out.println(q.enQueue(3));
        System.out.println(q.enQueue(4));

        System.out.println(q.Rear());

        System.out.println(q.isFull());

        System.out.println(q.deQueue());

        System.out.println(q.enQueue(4));

        System.out.println(q.Rear());
    }
}