package recursion;


public class CheckIfLinkedListIsSortedUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Check if Linked List is Sorted

      Pattern  : Recursion

      Approach :
      Recursive Order Checking

      Idea :
      - A linked list is sorted if it is
        either:
          • Non-decreasing (Ascending)
          • Non-increasing (Descending)
      - Recursively compare every node
        with its next node.
      - If any pair violates the required
        order, return false.
      - If the end of the list is reached,
        the list is sorted in that order.
      - Check both ascending and
        descending orders.

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

    public boolean isSorted(Node head) {

        return checkAscending(head) ||
               checkDescending(head);
    }

    private boolean checkAscending(Node head) {

        // Base Case
        if (head == null || head.next == null) {
            return true;
        }

        // Ascending order violated
        if (head.data > head.next.data) {
            return false;
        }

        return checkAscending(head.next);
    }

    private boolean checkDescending(Node head) {

        // Base Case
        if (head == null || head.next == null) {
            return true;
        }

        // Descending order violated
        if (head.data < head.next.data) {
            return false;
        }

        return checkDescending(head.next);
    }

    public static void main(String[] args) {

        CheckIfLinkedListIsSortedUsingRecursion obj =
                new CheckIfLinkedListIsSortedUsingRecursion();

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println(obj.isSorted(head));
    }
}