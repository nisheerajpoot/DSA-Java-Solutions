package recursion;

public class RemoveLinkedListElementsUsingRecursion {

    /*
      Platform : LeetCode

      Question : Remove Linked List Elements

      Pattern  : Recursion

      Approach :
      Recursive Node Deletion

      Idea :
      - Recursively process the remaining
        linked list first.
      - Connect the current node to the
        processed remaining list.
      - If the current node contains the
        target value, skip it by returning
        the next node.
      - Otherwise, keep the current node
        and return it.

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

    public ListNode removeElements(ListNode head, int val) {

        // Base Case
        if (head == null) {
            return null;
        }

        // Process remaining list
        head.next = removeElements(head.next, val);

        // Remove current node
        if (head.val == val) {
            return head.next;
        }

        // Keep current node
        return head;
    }

    static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        RemoveLinkedListElementsUsingRecursion obj =
                new RemoveLinkedListElementsUsingRecursion();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.print("Original List : ");
        printList(head);

        head = obj.removeElements(head, 6);

        System.out.print("Updated List  : ");
        printList(head);
    }
}