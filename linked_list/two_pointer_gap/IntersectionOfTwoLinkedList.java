package two_pointer_gap;


public class IntersectionOfTwoLinkedList {

    /*
      Platform : LeetCode
      Question : Intersection of Two Linked Lists
      Pattern  : Two Pointer Gap

      Approach :
      Two Pointer Switching Technique

      Idea :
      - Start pointer a from headA.
      - Start pointer b from headB.
      - When a reaches null, move it to headB.
      - When b reaches null, move it to headA.
      - If intersection exists, both pointers meet there.
      - Otherwise both become null together.

      Time Complexity :
      O(n + m)

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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {

        IntersectionOfTwoLinkedList obj =
                new IntersectionOfTwoLinkedList();

        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        ListNode ans = obj.getIntersectionNode(headA, headB);

        if (ans != null) {
            System.out.println("Intersection Node Value : " + ans.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}