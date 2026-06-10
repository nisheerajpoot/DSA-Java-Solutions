package fast_and_slow_pointer;

import java.util.Scanner;

public class PalindromeLinkedList {

    /*
      Platform : LeetCode
      Question : Palindrome Linked List
      Pattern  : Fast and Slow Pointer

      Approach :
      - Find middle of linked list.
      - Reverse second half.
      - Compare first half and second half.
      - If all values match, linked list is palindrome.

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

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;

        while (slow != null) {

            ListNode next = slow.next;

            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {

            if (first.val != second.val) {
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PalindromeLinkedList obj = new PalindromeLinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(false);
            return;
        }

        System.out.println("Enter node values:");

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {

            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        System.out.println(obj.isPalindrome(head));

        sc.close();
    }
}