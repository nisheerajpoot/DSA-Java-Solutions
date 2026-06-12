
package dummy_node_pattern;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedListwo {

    /*
      Platform : LeetCode
      Question : Remove Duplicates from Sorted List II
      Pattern  : Dummy Node Pattern

      Approach :
      Dummy Node + Two Pointer

      Idea :
      - If a value appears more than once,
        remove all occurrences of that value.
      - Keep only distinct numbers.
      - Dummy node helps when duplicates start from head.

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

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val) {

                while (curr.next != null &&
                       curr.val == curr.next.val) {
                    curr = curr.next;
                }

                prev.next = curr.next;
            }
            else {
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
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

        Scanner sc = new Scanner(System.in);

        RemoveDuplicatesFromSortedListwo obj = new RemoveDuplicatesFromSortedListwo();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            return;
        }

        System.out.println("Enter sorted list values:");

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {

            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        System.out.print("Original List : ");
        printList(head);

        head = obj.deleteDuplicates(head);

        System.out.print("Updated List  : ");
        printList(head);

        sc.close();
    }
}