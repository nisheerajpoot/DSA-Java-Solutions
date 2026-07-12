package recursion;

public class MoveLastNodeToFrontUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Move Last Node to Front of Linked List

      Pattern  : Recursion

      Approach :
      Recursive Traversal

      Idea :
      - Store the original head of the
        linked list.
      - Recursively traverse until the
        second last node is reached.
      - Detach the last node from the list.
      - Make the last node point to the
        original head.
      - Return the last node as the
        new head of the linked list.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node originalHead;

    public static Node moveToFront(Node head) {

        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        originalHead = head;

        return solve(head);
    }

    private static Node solve(Node head) {

        // Second Last Node Reached
        if (head.next.next == null) {

            Node last = head.next;

            // Detach Last Node
            head.next = null;

            // Move Last Node to Front
            last.next = originalHead;

            return last;
        }

        return solve(head.next);
    }

    static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.print("Original List : ");
        printList(head);

        head = moveToFront(head);

        System.out.print("Updated List  : ");
        printList(head);
    }
}