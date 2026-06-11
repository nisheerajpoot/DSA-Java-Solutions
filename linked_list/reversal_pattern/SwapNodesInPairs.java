package reversal_pattern;

import java.util.Scanner;

public class SwapNodesInPairs {

    /*
      Platform : LeetCode
      Question : Swap Nodes in Pairs
      Pattern  : Reversal Pattern

      Approach :
      Pairwise Linked List Reversal

      Idea :
      - Use a dummy node before head.
      - Take two nodes at a time.
      - Swap their links.
      - Move to next pair.
      - Repeat until less than two nodes remain.

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

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
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

        SwapNodesInPairs obj = new SwapNodesInPairs();

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

        head = obj.swapPairs(head);

        System.out.print("Updated List  : ");
        printList(head);

        sc.close();
    }
}