package fast_and_slow_pointer;

import java.util.Scanner;

public class MiddleOfTheLinkedList {

    /*
      Platform : LeetCode
      Question : Middle of the Linked List
      Pattern  : Fast and Slow Pointer

      Approach :
      - Slow pointer moves 1 step.
      - Fast pointer moves 2 steps.
      - When fast reaches the end,
        slow reaches the middle.

      Time Complexity :
      O(n)

      Space Complexity :
      O(1)
    */

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MiddleOfTheLinkedList obj =
                new MiddleOfTheLinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Enter node values:");

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {

            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        ListNode middle = obj.middleNode(head);

        System.out.println("Middle Node Value: " + middle.val);

        sc.close();
    }
}