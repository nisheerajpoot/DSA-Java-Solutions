package recursion;


public class ReverseNodesInKGroupUsingRecursion {

    /*
      Platform : LeetCode

      Question : Reverse Nodes in k-Group

      Pattern  : Recursion

      Approach :
      Recursive Group Reversal

      Idea :
      - Check whether at least k nodes
        are available.
      - If fewer than k nodes remain,
        return the current head without
        reversing.
      - Reverse the first k nodes using
        the standard iterative reversal.
      - Recursively reverse the remaining
        linked list.
      - Connect the last node of the
        current reversed group to the
        head of the recursively reversed
        remaining list.
      - Return the new head of the
        reversed group.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n / k)

      (Recursive Call Stack)
    */

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        // Base Case
        if (head == null) {
            return null;
        }

        // Check if k nodes exist
        ListNode curr = head;
        int count = 0;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Less than k nodes
        if (count < k) {
            return head;
        }

        // Reverse first k nodes
        ListNode prev = null;
        curr = head;
        count = 0;

        while (count < k) {

            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

            count++;
        }

        // Reverse remaining groups
        head.next = reverseKGroup(curr, k);

        return prev;
    }

    static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ReverseNodesInKGroupUsingRecursion obj =
                new ReverseNodesInKGroupUsingRecursion();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List : ");
        printList(head);

        head = obj.reverseKGroup(head, 2);

        System.out.print("Updated List  : ");
        printList(head);
    }
}