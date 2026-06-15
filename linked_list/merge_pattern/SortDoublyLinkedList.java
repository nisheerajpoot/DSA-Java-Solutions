package merge_pattern;

import java.util.Scanner;

public class SortDoublyLinkedList {

    /*
      Platform : GeeksforGeeks
      Question : Sort a Doubly Linked List
      Pattern  : Merge Pattern

      Approach :
      Merge Sort on Doubly Linked List

      Idea :
      - Find the middle node using slow and fast pointers.
      - Split the doubly linked list into two halves.
      - Recursively sort both halves.
      - Merge the two sorted halves.
      - While merging, maintain both next and prev pointers.

      Time Complexity :
      O(n log n)

      Space Complexity :
      O(log n)
      (Recursive Call Stack)
    */

    static class DLLNode {

        int data;
        DLLNode prev;
        DLLNode next;

        DLLNode(int data) {
            this.data = data;
        }
    }

    public DLLNode sort_doubly(DLLNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        DLLNode slow = head;
        DLLNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split list
        DLLNode second = slow.next;
        slow.next = null;

        if (second != null) {
            second.prev = null;
        }

        // Sort both halves
        DLLNode left = sort_doubly(head);
        DLLNode right = sort_doubly(second);

        // Merge
        return merge(left, right);
    }

    private DLLNode merge(DLLNode first, DLLNode second) {

        DLLNode dummy = new DLLNode(0);
        DLLNode temp = dummy;

        while (first != null && second != null) {

            if (first.data <= second.data) {

                temp.next = first;
                first.prev = temp;

                first = first.next;
            }
            else {

                temp.next = second;
                second.prev = temp;

                second = second.next;
            }

            temp = temp.next;
        }

        while (first != null) {

            temp.next = first;
            first.prev = temp;

            first = first.next;
            temp = temp.next;
        }

        while (second != null) {

            temp.next = second;
            second.prev = temp;

            second = second.next;
            temp = temp.next;
        }

        DLLNode newHead = dummy.next;

        if (newHead != null) {
            newHead.prev = null;
        }

        return newHead;
    }

    public static void printForward(DLLNode head) {

        while (head != null) {

            System.out.print(head.data);

            if (head.next != null) {
                System.out.print(" <-> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SortDoublyLinkedList obj =
                new SortDoublyLinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            return;
        }

        System.out.println("Enter node values:");

        DLLNode head = new DLLNode(sc.nextInt());
        DLLNode temp = head;

        for (int i = 1; i < n; i++) {

            DLLNode newNode = new DLLNode(sc.nextInt());

            temp.next = newNode;
            newNode.prev = temp;

            temp = newNode;
        }

        System.out.print("Original DLL : ");
        printForward(head);

        head = obj.sort_doubly(head);

        System.out.print("Sorted DLL   : ");
        printForward(head);

        sc.close();
    }
}