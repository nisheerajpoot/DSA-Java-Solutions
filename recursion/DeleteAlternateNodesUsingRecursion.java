package recursion;

public class DeleteAlternateNodesUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Delete Alternate Nodes

      Pattern  : Recursion

      Approach :
      Recursive Deletion

      Idea :
      - If the current node or the next
        node is null, stop recursion.
      - Delete the next (alternate) node
        by skipping it.
      - Recursively process the remaining
        linked list starting from the
        next available node.
      - Continue until the end of the list.

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

    public void deleteAlt(Node head) {

        // Base Case
        if (head == null || head.next == null) {
            return;
        }

        // Delete Alternate Node
        head.next = head.next.next;

        // Process Remaining List
        deleteAlt(head.next);
    }

    static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        DeleteAlternateNodesUsingRecursion obj =
                new DeleteAlternateNodesUsingRecursion();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.print("Original List : ");
        printList(head);

        obj.deleteAlt(head);

        System.out.print("Updated List  : ");
        printList(head);
    }
}