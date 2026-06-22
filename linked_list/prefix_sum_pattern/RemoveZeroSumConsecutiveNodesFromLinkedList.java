package prefix_sum_pattern;

import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    /*
      Platform : LeetCode
      Question : Remove Zero Sum Consecutive Nodes from Linked List

      Pattern  : Prefix Sum + HashMap

      Approach :
      Two Pass Prefix Sum

      Idea :
      - If the same prefix sum appears again,
        then the nodes between them sum to 0.
        
      Time Complexity :
      O(n)

      Space Complexity :
      O(n)
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

    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> map = new HashMap<>();

        int prefixSum = 0;
        ListNode curr = dummy;

        // First Pass
        while (curr != null) {

            prefixSum += curr.val;

            map.put(prefixSum, curr);

            curr = curr.next;
        }

        // Second Pass
        prefixSum = 0;
        curr = dummy;

        while (curr != null) {

            prefixSum += curr.val;

            curr.next = map.get(prefixSum).next;

            curr = curr.next;
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

        RemoveZeroSumConsecutiveNodesFromLinkedList obj =
                new RemoveZeroSumConsecutiveNodesFromLinkedList();

        /*
           Example:

           1 -> 2 -> -3 -> 3 -> 1

           Output:

           3 -> 1
        */

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        System.out.print("Original List : ");
        printList(head);

        head = obj.removeZeroSumSublists(head);

        System.out.print("Updated List  : ");
        printList(head);
    }
}