package recursion;

public class ReverseDoublyLinkedListUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Reverse a Doubly Linked List

      Pattern  : Recursion

      Approach :
      Recursive Pointer Swapping

      Idea :
      - For every node, swap its
        next and prev pointers.
      - After swapping, move to the
        original next node, which is
        now stored in prev.
      - Continue recursively until
        the last node is reached.
      - The last node becomes the
        new head of the reversed list.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    static class Node {

        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public Node reverse(Node head) {

        // Base Case
        if (head == null) {
            return null;
        }

        // Swap next and prev pointers
        Node temp = head.next;
        head.next = head.prev;
        head.prev = temp;

        // Last node becomes new head
        if (head.prev == null) {
            return head;
        }

        // Reverse remaining list
        return reverse(head.prev);
    }

    static void printForward(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");

            if (head.next == null) {
                break;
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ReverseDoublyLinkedListUsingRecursion obj =
                new ReverseDoublyLinkedListUsingRecursion();

        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        head.next = second;
        second.prev = head;

        second.next = third;
        third.prev = second;

        third.next = fourth;
        fourth.prev = third;

        System.out.print("Original List : ");
        printForward(head);

        head = obj.reverse(head);

        System.out.print("Reversed List : ");
        printForward(head);
    }
}