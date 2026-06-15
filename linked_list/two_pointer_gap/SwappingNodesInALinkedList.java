package two_pointer_gap;

import java.util.Scanner;

public class SwappingNodesInALinkedList {

    /*
      Platform : LeetCode
      Question : Swapping Nodes in a Linked List
      Pattern  : Two Pointer Gap

      Approach :
      Find kth Node From Start and kth Node From End

      Idea :
      - Find kth node from beginning.
      - Keep fast at kth node.
      - Move slow from head and fast together.
      - When fast reaches last node,
        slow reaches kth node from end.
      - Swap values of both nodes.

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

    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode slow = head;
        ListNode fast = first;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        int temp = first.val;
        first.val = slow.val;
        slow.val = temp;

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

        SwappingNodesInALinkedList obj =
                new SwappingNodesInALinkedList();

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

        head = obj.swapNodes(head, k);

        System.out.print("Updated List  : ");
        printList(head);

        sc.close();
    }
}