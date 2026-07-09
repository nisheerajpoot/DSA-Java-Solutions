package recursion;

public class SortLinkedListUsingRecursion {

    /*
      Platform : LeetCode

      Question : Sort List

      Pattern  : Recursion

      Approach :
      Merge Sort

      Idea :
      - Find the middle of the linked list
        using Slow and Fast pointers.
      - Split the list into two halves.
      - Recursively sort both halves.
      - Merge the two sorted linked lists
        recursively.
      - The recursion continues until each
        sublist contains only one node.

      Time Complexity :
      O(n log n)

      Space Complexity :
      O(log n)

      (Recursive Call Stack)
    */

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head) {

        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        // Find Middle
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Split List
        ListNode second = slow.next;
        slow.next = null;

        // Sort Both Halves
        ListNode left = sortList(head);
        ListNode right = sortList(second);

        // Merge Sorted Lists
        return merge(left, right);
    }

    private ListNode merge(ListNode first,
                           ListNode second) {

        // Base Cases
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        // Merge Recursively
        if (first.val <= second.val) {

            first.next = merge(first.next, second);

            return first;
        }

        second.next = merge(first, second.next);

        return second;
    }

    static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        SortLinkedListUsingRecursion obj =
                new SortLinkedListUsingRecursion();

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.print("Original List : ");
        printList(head);

        head = obj.sortList(head);

        System.out.print("Sorted List   : ");
        printList(head);
    }
}