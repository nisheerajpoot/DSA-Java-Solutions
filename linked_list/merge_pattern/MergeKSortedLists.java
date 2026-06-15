package merge_pattern;

import java.util.Scanner;

public class MergeKSortedLists {

    /*
      Platform : LeetCode
      Question : Merge k Sorted Lists
      Pattern  : Merge Pattern

      Approach :
      Sequential Merge

      Idea :
      - Start with first linked list.
      - Merge it with second list.
      - Merge the result with third list.
      - Continue until all lists are merged.
      - Uses Merge Two Sorted Lists logic.

      Time Complexity :
      O(N * k)

      N = Total nodes across all lists
      k = Number of linked lists

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        }

        if (list2 != null) {
            temp.next = list2;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode ans = lists[0];

        for (int i = 1; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }

        return ans;
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

        MergeKSortedLists obj = new MergeKSortedLists();

        System.out.print("Enter number of linked lists: ");
        int k = sc.nextInt();

        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {

            System.out.print("Enter size of list " + (i + 1) + ": ");
            int n = sc.nextInt();

            if (n == 0) {
                continue;
            }

            System.out.println("Enter elements:");

            lists[i] = new ListNode(sc.nextInt());
            ListNode temp = lists[i];

            for (int j = 1; j < n; j++) {

                temp.next = new ListNode(sc.nextInt());
                temp = temp.next;
            }
        }

        ListNode ans = obj.mergeKLists(lists);

        System.out.print("Merged List : ");
        printList(ans);

        sc.close();
    }
}