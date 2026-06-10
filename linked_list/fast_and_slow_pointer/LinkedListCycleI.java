package fast_and_slow_pointer;

import java.util.Scanner;

public class LinkedListCycleI {

    /*
      Platform : LeetCode
      Question : Linked List Cycle
      Pattern  : Fast and Slow Pointer (Floyd Cycle Detection)

      Approach :
      - Slow pointer moves 1 step.
      - Fast pointer moves 2 steps.
      - If cycle exists, both pointers will meet.
      - If fast reaches null, cycle does not exist.

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

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedListCycleI obj = new LinkedListCycleI();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println(false);
            return;
        }

        System.out.println("Enter node values:");

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        ListNode[] nodes = new ListNode[n];
        nodes[0] = head;

        for (int i = 1; i < n; i++) {

            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
            nodes[i] = temp;
        }

        System.out.print("Enter cycle position (-1 for no cycle): ");
        int pos = sc.nextInt();

        if (pos != -1) {
            temp.next = nodes[pos];
        }

        System.out.println(obj.hasCycle(head));

        sc.close();
    }
}