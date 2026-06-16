package in_place_rearrangement;

import java.util.Scanner;

public class EvenOddLinkedList {

    /*
      Platform : LeetCode
      Question : Odd Even Linked List
      Pattern  : In-Place Rearrangement

      Approach :
      Separate Odd and Even Position Nodes

      Idea :
      - Maintain two pointers:
        odd  -> odd position nodes
        even -> even position nodes

      - Connect all odd nodes together.
      - Connect all even nodes together.
      - Attach even list at the end of odd list.

      Note:
      Position is considered, not value.

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

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

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

        EvenOddLinkedList obj = new EvenOddLinkedList();

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

        head = obj.oddEvenList(head);

        System.out.print("Rearranged List : ");
        printList(head);

        sc.close();
    }
}