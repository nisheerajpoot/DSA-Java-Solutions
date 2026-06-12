package dummy_node_pattern;

import java.util.Scanner;

public class RemoveNthNodeFromEndOfList {

    /*
      Platform : LeetCode
      Question : Remove Nth Node From End of List
      Pattern  : Dummy Node Pattern

      Approach :
      Dummy Node + Fast and Slow Pointer

      Idea :
      - Create a dummy node before head.
      - Move fast pointer n + 1 steps ahead.
      - Move slow and fast together.
      - When fast reaches null,
        slow reaches the node before the node to delete.
      - Delete slow.next.

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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {

            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

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

        RemoveNthNodeFromEndOfList obj =
                new RemoveNthNodeFromEndOfList();

        System.out.print("Enter number of nodes: ");
        int size = sc.nextInt();

        if (size == 0) {
            return;
        }

        System.out.println("Enter node values:");

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < size; i++) {

            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Original List : ");
        printList(head);

        head = obj.removeNthFromEnd(head, n);

        System.out.print("Updated List  : ");
        printList(head);

        sc.close();
    }
}