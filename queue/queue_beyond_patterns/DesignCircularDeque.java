package queue.queue_beyond_patterns;

public class DesignCircularDeque {

    /*
      Platform : LeetCode
      Question : Design Circular Deque


      Approach :
      Circular Array Simulation

      Idea :
      - Use a fixed-size circular array.
      - front points to first element.
      - rear points to last element.
      - Insert/Delete from both ends in O(1).
      - Circular movement is handled using modulo (%).

      Time Complexity :
      insertFront() -> O(1)
      insertLast()  -> O(1)
      deleteFront() -> O(1)
      deleteLast()  -> O(1)
      getFront()    -> O(1)
      getRear()     -> O(1)
      isEmpty()     -> O(1)
      isFull()      -> O(1)

      Space Complexity :
      O(k)
    */

    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    public DesignCircularDeque(int k) {

        arr = new int[k];
        capacity = k;
        front = 0;
        rear = k - 1;
        size = 0;
    }

    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        size++;

        return true;
    }

    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;

        return true;
    }

    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        rear = (rear - 1 + capacity) % capacity;
        size--;

        return true;
    }

    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        return arr[rear];
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public boolean isFull() {

        return size == capacity;
    }

    public static void main(String[] args) {

        DesignCircularDeque deque = new DesignCircularDeque(3);

        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertFront(3));
        System.out.println(deque.insertFront(4));

        System.out.println(deque.getRear());

        System.out.println(deque.isFull());

        System.out.println(deque.deleteLast());

        System.out.println(deque.insertFront(4));

        System.out.println(deque.getFront());
    }
}