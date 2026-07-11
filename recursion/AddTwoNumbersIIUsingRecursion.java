package recursion;

public class AddTwoNumbersIIUsingRecursion {

    /*
      Platform : LeetCode

      Question : Add Two Numbers II

      Pattern  : Recursion

      Approach :
      Recursive Addition from End

      Idea :
      - Find the lengths of both
        linked lists.
      - Recursively move to the last
        nodes of both lists.
      - If one list is longer, keep
        moving only in the longer list
        until both lists become aligned.
      - While returning from recursion,
        add the corresponding digits
        along with the carry.
      - Create the current node using
        the digit (sum % 10).
      - Update the carry for the next
        recursive return.
      - If a carry remains after all
        additions, create a new head.

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

    private int carry = 0;

    public ListNode addTwoNumbers(ListNode l1,
                                  ListNode l2) {

        int len1 = length(l1);
        int len2 = length(l2);

        ListNode head = add(l1, len1, l2, len2);

        // Remaining Carry
        if (carry > 0) {

            ListNode newHead = new ListNode(carry);

            newHead.next = head;

            return newHead;
        }

        return head;
    }

    private int length(ListNode head) {

        int len = 0;

        while (head != null) {

            len++;

            head = head.next;
        }

        return len;
    }

    private ListNode add(ListNode l1,
                         int len1,
                         ListNode l2,
                         int len2) {

        // Base Case
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode nextNode;
        int sum;

        // Longer First List
        if (len1 > len2) {

            nextNode = add(l1.next,
                           len1 - 1,
                           l2,
                           len2);

            sum = l1.val + carry;
        }

        // Longer Second List
        else if (len2 > len1) {

            nextNode = add(l1,
                           len1,
                           l2.next,
                           len2 - 1);

            sum = l2.val + carry;
        }

        // Same Length
        else {

            nextNode = add(l1.next,
                           len1 - 1,
                           l2.next,
                           len2 - 1);

            sum = l1.val + l2.val + carry;
        }

        carry = sum / 10;

        ListNode current = new ListNode(sum % 10);

        current.next = nextNode;

        return current;
    }

    static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        AddTwoNumbersIIUsingRecursion obj =
                new AddTwoNumbersIIUsingRecursion();

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.print("First Number  : ");
        printList(l1);

        System.out.print("Second Number : ");
        printList(l2);

        ListNode result = obj.addTwoNumbers(l1, l2);

        System.out.print("Result        : ");
        printList(result);
    }
}