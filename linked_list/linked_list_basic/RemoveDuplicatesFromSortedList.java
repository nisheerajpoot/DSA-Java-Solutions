package linked_list_basic;

public class RemoveDuplicatesFromSortedList {

    /*
      Platform : LeetCode
      Question : Remove Duplicates from Sorted List (LC 83)

      Pattern  : Linked List Traversal

      Approach :
      Compare Current Node with Next Node

      Idea :
      - Since the list is sorted,
        duplicate values will always be adjacent.
      - If current value equals next value,
        skip the duplicate node.
      - Otherwise move forward.


      Time Complexity :
      O(n)

      Space Complexity :
      O(1)
    */

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {

                curr.next = curr.next.next;

            } else {

                curr = curr.next;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedList obj =
                new RemoveDuplicatesFromSortedList();

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