package two_pointer_gap;

import java.util.Scanner;

public class KthNodeFromEndOfLinkedList {

    /*
      Platform : GeeksforGeeks
      Question : Kth Node From End Of Linked List
      Pattern  : Two Pointer Gap

      Approach :
      Fast and Slow Pointer

      Idea :
      - Move fast pointer k steps ahead.
      - This creates a gap of k nodes.
      - Move both pointers together.
      - When fast reaches null,
        slow reaches the kth node from the end.

      Time Complexity :
      O(n)

      Space Complexity :
      O(1)
    */

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    int getKthFromLast(Node head, int k) {

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {

            if (fast == null) {
                return -1;
            }

            fast = fast.next;
        }

        while (fast != null) {

            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        KthNodeFromEndOfLinkedList obj =
                new KthNodeFromEndOfLinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            return;
        }

        System.out.println("Enter node values:");

        Node head = new Node(sc.nextInt());
        Node temp = head;

        for (int i = 1; i < n; i++) {

            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int ans = obj.getKthFromLast(head, k);

        System.out.println("Kth Node From End: " + ans);

        sc.close();
    }
}