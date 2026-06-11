package reversal_pattern;

import java.util.Scanner;

public class ReverseNodesInKGroup {

    /*
      Platform : LeetCode
      Question : Reverse Nodes in k-Group
      Pattern  : Reversal Pattern

      Approach :
      Reverse Linked List in Groups of Size k

      Idea :
      - Count total nodes.
      - Find number of complete groups.
      - Reverse each group of k nodes using
        head insertion technique.
      - Remaining nodes (< k) stay unchanged.

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

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        int groups = count / k;

        while (groups > 0) {

            for (int i = 0; i < k - 1; i++) {

                ListNode next = curr.next;

                curr.next = next.next;

                next.next = prev.next;

                prev.next = next;
            }

            prev = curr;
            curr = curr.next;

            groups--;
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

        Scanner sc = new Scanner(System.in);

        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            return;
        }

        System.out.println("Enter node values:");

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {

            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.print("Original List : ");
        printList(head);

        head = obj.reverseKGroup(head, k);

        System.out.print("Updated List  : ");
        printList(head);

        sc.close();
    }
}