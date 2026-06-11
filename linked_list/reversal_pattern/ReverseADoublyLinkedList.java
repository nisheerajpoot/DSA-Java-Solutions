package reversal_pattern;

import java.util.Scanner;

public class ReverseADoublyLinkedList {

    /*
      Platform : GeeksforGeeks / Interview Question
      Question : Reverse a Doubly Linked List
      Pattern  : Reversal Pattern

      Approach :
      Iterative Reversal

      Idea :
      - Swap next and prev pointers of every node.
      - Move using the original next node.
      - Last processed node becomes new head.

      Time Complexity :
      O(n)

      Space Complexity :
      O(1)
    */

    static class Node {

        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node reverseDLL(Node head) {

        Node curr = head;
        Node temp = null;

        while (curr != null) {

            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    public static void printList(Node head) {

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

        ReverseADoublyLinkedList obj =
                new ReverseADoublyLinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            return;
        }

        System.out.println("Enter node values:");

        Node head = new Node(sc.nextInt());
        Node temp = head;

        for (int i = 1; i < n; i++) {

            Node newNode = new Node(sc.nextInt());

            temp.next = newNode;
            newNode.prev = temp;

            temp = newNode;
        }

        System.out.print("Original DLL : ");
        printList(head);

        head = obj.reverseDLL(head);

        System.out.print("Reversed DLL : ");
        printList(head);

        sc.close();
    }
}