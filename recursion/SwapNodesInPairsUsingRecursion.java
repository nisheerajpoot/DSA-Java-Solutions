package recursion;


public class SwapNodesInPairsUsingRecursion {

    /*
      Platform : LeetCode

      Question : Swap Nodes in Pairs

      Pattern  : Recursion

      Approach :
      Recursive Pair Swapping

      Idea :
      - If the list has fewer than two
        nodes, return the head.
      - Take the first two nodes.
      - Recursively swap the remaining
        linked list.
      - Connect the first node to the
        head of the recursively swapped
        remaining list.
      - Make the second node point to
        the first node.
      - Return the second node as the
        new head of the current pair.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {

        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        // First Two Nodes
        ListNode first = head;
        ListNode second = head.next;

        // Swap Remaining List
        first.next = swapPairs(second.next);

        // Swap Current Pair
        second.next = first;

        return second;
    }

    static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        SwapNodesInPairsUsingRecursion obj =
                new SwapNodesInPairsUsingRecursion();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original List : ");
        printList(head);

        head = obj.swapPairs(head);

        System.out.print("Updated List  : ");
        printList(head);
    }
}