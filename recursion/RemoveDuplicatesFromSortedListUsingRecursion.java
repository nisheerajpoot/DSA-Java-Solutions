package recursion;


public class RemoveDuplicatesFromSortedListUsingRecursion {

    /*
      Platform : LeetCode

      Question : Remove Duplicates from Sorted List

      Pattern  : Recursion

      Approach :
      Recursive Duplicate Removal

      Idea :
      - Recursively process the remaining
        linked list.
      - Connect the current node to the
        processed remaining list.
      - Since the list is sorted,
        duplicate values are adjacent.
      - If the current node and next node
        have the same value, skip the
        current node.
      - Otherwise, keep the current node.

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

    public ListNode deleteDuplicates(ListNode head) {

        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        // Process remaining list
        head.next = deleteDuplicates(head.next);

        // Remove duplicate node
        if (head.val == head.next.val) {
            return head.next;
        }

        // Keep current node
        return head;
    }

    static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedListUsingRecursion obj =
                new RemoveDuplicatesFromSortedListUsingRecursion();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.print("Original List : ");
        printList(head);

        head = obj.deleteDuplicates(head);

        System.out.print("Updated List  : ");
        printList(head);
    }
}