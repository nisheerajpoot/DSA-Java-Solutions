package linked_list_traversal;

public class RemoveLinkedListElements {

    /*
      Platform : LeetCode
      Question : Remove Linked List Elements (LC 203)

      Pattern  : Linked List Traversal + Dummy Node

      Approach :
      Traverse the list and remove nodes
      whose value equals target value.


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
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null) {

            if (curr.next.val == val) {

                curr.next = curr.next.next;

            } else {

                curr = curr.next;
            }
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

        RemoveLinkedListElements obj =
                new RemoveLinkedListElements();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int val = 6;

        System.out.print("Original List : ");
        printList(head);

        head = obj.removeElements(head, val);

        System.out.print("Updated List  : ");
        printList(head);
    }
}