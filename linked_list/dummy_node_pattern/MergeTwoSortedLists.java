package dummy_node_pattern;

import java.util.Scanner;

public class MergeTwoSortedLists {

    /*
      Platform : LeetCode
      Question : Merge Two Sorted Lists
      Pattern  : Dummy Node Pattern

      Approach :
      Dummy Node + Two Pointer

      Idea :
      - Create a dummy node.
      - Compare nodes from both lists.
      - Attach the smaller node to result list.
      - Move corresponding pointer.
      - Attach remaining nodes at the end.

      Time Complexity :
      O(n + m)

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                temp.next = list1;
                list1 = list1.next;

            } else {

                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        }

        if (list2 != null) {
            temp.next = list2;
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

        MergeTwoSortedLists obj = new MergeTwoSortedLists();

        System.out.print("Enter size of first list: ");
        int n1 = sc.nextInt();

        ListNode list1 = null;
        ListNode temp1 = null;

        if (n1 > 0) {

            System.out.println("Enter first sorted list:");

            list1 = new ListNode(sc.nextInt());
            temp1 = list1;

            for (int i = 1; i < n1; i++) {

                temp1.next = new ListNode(sc.nextInt());
                temp1 = temp1.next;
            }
        }

        System.out.print("Enter size of second list: ");
        int n2 = sc.nextInt();

        ListNode list2 = null;
        ListNode temp2 = null;

        if (n2 > 0) {

            System.out.println("Enter second sorted list:");

            list2 = new ListNode(sc.nextInt());
            temp2 = list2;

            for (int i = 1; i < n2; i++) {

                temp2.next = new ListNode(sc.nextInt());
                temp2 = temp2.next;
            }
        }

        ListNode merged = obj.mergeTwoLists(list1, list2);

        System.out.print("Merged List : ");
        printList(merged);

        sc.close();
    }
}