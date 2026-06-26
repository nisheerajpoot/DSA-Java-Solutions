package hashmap_doubly_linked_list;

import java.util.HashSet;

public class LinkedListComponents {

    /*
      Platform : LeetCode
      Question : Linked List Components (LC 817)

      Pattern  : HashSet + Linked List Traversal

      Approach :
      Hashing

      Idea :
      - Store all values from nums[] into a HashSet.
      - Traverse the linked list once.
      - If current node belongs to the HashSet and
        the next node is either:
            • null, or
            • not present in the HashSet,
        then one connected component ends here.
      - Increase the component count.

    
      Time Complexity :
      O(n + m)

      n = Number of nodes in Linked List
      m = Size of nums[]

      Space Complexity :
      O(m)
    */

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int numComponents(ListNode head, int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Store all values of nums[] in HashSet
        for (int num : nums) {
            set.add(num);
        }

        int count = 0;

        ListNode curr = head;

        while (curr != null) {

            if (set.contains(curr.val)) {

                // End of one connected component
                if (curr.next == null ||
                        !set.contains(curr.next.val)) {

                    count++;
                }
            }

            curr = curr.next;
        }

        return count;
    }

    public static void main(String[] args) {

        LinkedListComponents obj = new LinkedListComponents();

        // Linked List : 0 -> 1 -> 2 -> 3

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        int[] nums = {0, 1, 3};

        System.out.println(obj.numComponents(head, nums)); // 2
    }
}