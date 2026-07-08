package recursion;


public class ReverseLinkedListUsingRecursion {

    /*
      Platform : LeetCode

      Question : Reverse Linked List

      Pattern  : Recursion

      Approach :
      Recursive Pointer Reversal

      Idea :
      - Traverse recursively until the
        last node is reached.
      - The last node becomes the
        new head of the reversed list.
      - While returning from recursion,
        reverse each link:
            head.next.next = head
      - Break the old forward link by
        setting:
            head.next = null
      - Finally, return the new head.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {

        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse remaining list
        ListNode newHead = reverseList(head.next);

        // Reverse current link
        head.next.next = head;

        // Make current node the last node
        head.next = null;

        return newHead;
    }

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ReverseLinkedListUsingRecursion obj =
                new ReverseLinkedListUsingRecursion();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List : ");
        printList(head);

        head = obj.reverseList(head);

        System.out.print("Reversed List : ");
        printList(head);
    }
}