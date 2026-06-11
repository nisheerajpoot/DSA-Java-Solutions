package reversal_pattern;

import java.util.Scanner;

public class ReverseLinkedListII {

    /*
      Platform : LeetCode
      Question : Reverse Linked List II
      Pattern  : Reversal Pattern

      Approach :
      In-Place Sublist Reversal

      Idea :
      - Move prev to the node before position left.
      - curr points to first node of sublist.
      - Repeatedly take next node and insert it
        immediately after prev.
      - Reverse only the required part.

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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dum = new ListNode(0);
        dum.next = head;

        ListNode prev = dum;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            curr.next = next.next;

            next.next = prev.next;

            prev.next = next;
        }

        return dum.next;
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

        ReverseLinkedListII obj = new ReverseLinkedListII();

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

        System.out.print("Enter left position: ");
        int left = sc.nextInt();

        System.out.print("Enter right position: ");
        int right = sc.nextInt();

        System.out.print("Original List : ");
        printList(head);

        head = obj.reverseBetween(head, left, right);

        System.out.print("Updated List  : ");
        printList(head);

        sc.close();
    }
}