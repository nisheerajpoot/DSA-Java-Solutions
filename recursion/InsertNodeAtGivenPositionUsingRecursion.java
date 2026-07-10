package recursion;

public class InsertNodeAtGivenPositionUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Insert Node at Given Position

      Pattern  : Recursion

      Approach :
      Recursive Insertion

      Idea :
      - Traverse the linked list
        recursively while decreasing
        the position.
      - When the required position
        becomes 1, create a new node.
      - Insert the new node before the
        current node.
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

    public Node insertPos(Node head, int pos, int val) {

        // Insert at beginning
        if (pos == 1) {

            Node newNode = new Node(val);

            newNode.next = head;

            return newNode;
        }

        // Invalid Position
        if (head == null) {
            return null;
        }

        // Insert in remaining list
        head.next = insertPos(head.next, pos - 1, val);

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

        InsertNodeAtGivenPositionUsingRecursion obj =
                new InsertNodeAtGivenPositionUsingRecursion();

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(40);

        System.out.print("Original List : ");
        printList(head);

        head = obj.insertPos(head, 3, 30);

        System.out.print("Updated List  : ");
        printList(head);
    }
}