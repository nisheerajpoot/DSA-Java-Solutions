package in_place_rearrangement;

import java.util.Scanner;

public class DeleteNodesHavingGreaterValueOnRight {

    /*
      Platform : GeeksforGeeks
      Question : Delete Nodes Having Greater Value On Right

      Pattern  : In-Place Rearrangement

      Approach :
      Reverse + Maximum Tracking

      Idea :
      - Reverse the linked list.
      - Traverse from left to right.
      - Keep track of maximum value seen so far.
      - If next node is smaller than maximum,
        delete it.
      - Otherwise update maximum.
      - Reverse the list again.

    
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

    Node reverse(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    Node compute(Node head) {

        head = reverse(head);

        Node curr = head;
        int max = curr.data;

        while (curr != null && curr.next != null) {

            if (curr.next.data < max) {

                curr.next = curr.next.next;
            }
            else {

                curr = curr.next;
                max = curr.data;
            }
        }

        return reverse(head);
    }

    static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DeleteNodesHavingGreaterValueOnRight obj =
                new DeleteNodesHavingGreaterValueOnRight();

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

        System.out.print("Original List : ");
        printList(head);

        head = obj.compute(head);

        System.out.print("Updated List  : ");
        printList(head);

        sc.close();
    }
}