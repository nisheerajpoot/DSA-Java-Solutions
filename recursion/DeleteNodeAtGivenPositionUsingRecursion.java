package recursion;


public class DeleteNodeAtGivenPositionUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Delete Node at Given Position

      Pattern  : Recursion

      Approach :
      Recursive Deletion

      Idea :
      - Traverse the linked list
        recursively while decreasing
        the position.
      - When the position becomes 1,
        delete the current node by
        returning its next node.
      - While returning from recursion,
        reconnect all previous nodes.
      - Return the updated head.

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

    public Node deleteAtPosition(Node head, int pos) {

        // Base Case
        if (head == null) {
            return null;
        }

        // Delete Current Node
        if (pos == 1) {
            return head.next;
        }

        // Delete in Remaining List
        head.next = deleteAtPosition(head.next, pos - 1);

        return head;
    }

    static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        DeleteNodeAtGivenPositionUsingRecursion obj =
                new DeleteNodeAtGivenPositionUsingRecursion();

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.print("Original List : ");
        printList(head);

        head = obj.deleteAtPosition(head, 3);

        System.out.print("Updated List  : ");
        printList(head);
    }
}