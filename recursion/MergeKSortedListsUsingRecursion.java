package recursion;

public class MergeKSortedListsUsingRecursion {

    /*
      Platform : LeetCode

      Question : Merge k Sorted Lists

      Pattern  : Recursion

      Approach :
      Divide and Conquer

      Idea :
      - Divide the array of linked lists
        into two halves.
      - Recursively merge the left half
        and the right half.
      - Merge the two sorted linked lists
        recursively.
      - Continue dividing until only one
        linked list remains in each part.
      - This approach is similar to
        Merge Sort.

      Time Complexity :
      O(N log k)

      where:
      N = Total number of nodes
      k = Number of linked lists

      Space Complexity :
      O(log k)

      (Recursive Call Stack)
    */

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        // Base Case
        if (lists == null || lists.length == 0) {
            return null;
        }

        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists,
                            int left,
                            int right) {

        // Base Case
        if (left == right) {
            return lists[left];
        }

        // Find Middle
        int mid = left + (right - left) / 2;

        // Divide Left Half
        ListNode leftList = divide(lists, left, mid);

        // Divide Right Half
        ListNode rightList = divide(lists, mid + 1, right);

        // Merge Both Halves
        return merge(leftList, rightList);
    }

    private ListNode merge(ListNode first,
                           ListNode second) {

        // Base Cases
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        // Merge Recursively
        if (first.val <= second.val) {

            first.next = merge(first.next, second);

            return first;
        }

        second.next = merge(first, second.next);

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

        MergeKSortedListsUsingRecursion obj =
                new MergeKSortedListsUsingRecursion();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        ListNode head = obj.mergeKLists(lists);

        System.out.print("Merged List : ");
        printList(head);
    }
}