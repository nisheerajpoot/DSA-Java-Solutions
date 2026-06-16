package in_place_rearrangement;

import java.util.Scanner;

public class PartitionList {

    /*
      Platform : LeetCode
      Question : Partition List
      Pattern  : In-Place Rearrangement

      Approach :
      Two Dummy Lists

      Idea :
      - Create two separate lists:
        1. Nodes smaller than x
        2. Nodes greater than or equal to x

      - Traverse the original list.
      - Place each node into the appropriate list.
      - Finally connect both lists.
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

    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        ListNode curr = head;

        while (curr != null) {

            if (curr.val < x) {

                small.next = curr;
                small = small.next;

            } else {

                large.next = curr;
                large = large.next;
            }

            curr = curr.next;
        }

        large.next = null;

        small.next = largeDummy.next;

        return smallDummy.next;
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

        PartitionList obj = new PartitionList();

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

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        System.out.print("Original List : ");
        printList(head);

        head = obj.partition(head, x);

        System.out.print("Partition List : ");
        printList(head);

        sc.close();
    }
}