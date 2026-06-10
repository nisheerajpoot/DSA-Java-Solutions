package fast_and_slow_pointer;

import java.util.Scanner;

public class LinkedListCycleII {

    /*
      Platform : LeetCode
      Question : Linked List Cycle II
      Pattern  : Fast and Slow Pointer (Floyd Cycle Detection)

      Approach :
      - First detect whether a cycle exists.
      - If slow and fast meet, start one pointer from head.
      - Move both pointers one step at a time.
      - The node where they meet again is the starting node of the cycle.

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

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                ListNode ptr = head;

                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }

                return ptr;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedListCycleII obj = new LinkedListCycleII();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("No nodes present");
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

        ListNode ans = obj.detectCycle(head);

        if (ans == null) {
            System.out.println("No Cycle");
        } else {
            System.out.println("Cycle starts at node value: " + ans.val);
        }

        sc.close();
    }
}