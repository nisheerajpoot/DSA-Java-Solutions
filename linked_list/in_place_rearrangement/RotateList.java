package in_place_rearrangement;

import java.util.Scanner;

public class RotateList {

    /*
      Platform : LeetCode
      Question : Rotate List
      Pattern  : In-Place Rearrangement

      Approach :
      Circular Linked List

      Idea :
      - Find length of linked list.
      - Calculate effective rotations using:
            k = k % length
      - Connect tail to head and make a circle.
      - Find new tail at:
            length - k - 1
      - New head is next of new tail.
      - Break the circle.

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

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        tail.next = head;

        int steps = length - k - 1;

        ListNode newTail = head;

        for (int i = 0; i < steps; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
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

        RotateList obj = new RotateList();

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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.print("Original List : ");
        printList(head);

        head = obj.rotateRight(head, k);

        System.out.print("Rotated List  : ");
        printList(head);

        sc.close();
    }
}