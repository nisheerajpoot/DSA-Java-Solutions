package recursion_pattern;

public class ReverseLinkedListUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Reverse a Linked List

      Pattern  : Recursion

      Approach :
      Recursive Backtracking

      Idea :
      - Traverse recursively until reaching
        the last node.
      - The last node becomes the new head.
      - While returning from recursion,
        reverse each link.
      - Finally, make the current node's
        next pointer null to avoid cycles.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

    */

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node reverseList(Node head) {

        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse remaining list
        Node newHead = reverseList(head.next);

        // Reverse current link
        head.next.next = head;

        // Make current node last
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        ReverseLinkedListUsingRecursion obj =
                new ReverseLinkedListUsingRecursion();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node newHead = obj.reverseList(head);

        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }
}