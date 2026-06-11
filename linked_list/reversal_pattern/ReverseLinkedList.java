package reversal_pattern;

import java.util.Scanner;

public class ReverseLinkedList {

    /*
      Platform : LeetCode
      Question : Reverse Linked List
      Pattern  : Reversal Pattern

      Approach :
      Iterative Reversal

      Idea :
      - Maintain three pointers:
        prev, curr, next
      - Reverse the link of current node.
      - Move all pointers forward.
      - At the end, prev becomes the new head.

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

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;
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

        ReverseLinkedList obj = new ReverseLinkedList();

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

        ListNode reversedHead = obj.reverseList(head);

        System.out.print("Reversed List : ");
        printList(reversedHead);

        sc.close();
    }
}