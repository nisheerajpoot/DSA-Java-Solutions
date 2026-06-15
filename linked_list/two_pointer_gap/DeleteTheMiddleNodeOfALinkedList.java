package two_pointer_gap;

import java.util.Scanner;

public class DeleteTheMiddleNodeOfALinkedList {

    /*
      Platform : LeetCode
      Question : Delete the Middle Node of a Linked List
      Pattern  : Two Pointer Gap

      Approach :
      Fast and Slow Pointer

      Idea :
      - Slow moves one step.
      - Fast moves two steps.
      - Keep track of previous node of slow.
      - When fast reaches end,
        slow points to middle node.
      - Remove middle node using prev.

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

    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

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

        Scanner sc = new Scanner(System.in);

        DeleteTheMiddleNodeOfALinkedList obj =
                new DeleteTheMiddleNodeOfALinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            return;
        }

        System.out.println("Enter node values:");

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {

            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        System.out.print("Original List : ");
        printList(head);

        head = obj.deleteMiddle(head);

        System.out.print("Updated List  : ");
        printList(head);

        sc.close();
    }
}