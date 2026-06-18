package cycle_detection;

public class RemoveLoopInLinkedList {

    /*
      Platform : GeeksforGeeks
      Question : Remove Loop in Linked List
      Pattern  : Cycle Detection (Floyd's Algorithm)

      Approach :
      Detect Cycle + Find Last Node of Loop

      Idea :
      1. Detect cycle using slow and fast pointers.
      2. If no cycle exists, return.
      3. If cycle exists:
         - Find the node just before the start of the loop.
         - Break the loop by setting next = null.

      Time Complexity :
      O(n)

      Space Complexity :
      O(1)
    */

    static class Node {

        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public static void removeLoop(Node head) {

        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        boolean cycle = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle) {
            return;
        }

        slow = head;

        if (slow == fast) {

            while (fast.next != slow) {
                fast = fast.next;
            }

            fast.next = null;
            return;
        }


        while (slow.next != fast.next) {

            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;
    }

    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {


        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.next.next.next.next.next = head.next.next;

        removeLoop(head);

        System.out.println("Linked List After Removing Loop:");

        printList(head);
    }
}
