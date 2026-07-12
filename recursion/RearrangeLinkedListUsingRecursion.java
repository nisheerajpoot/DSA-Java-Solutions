package recursion;

public class RearrangeLinkedListUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Rearrange a Linked List

      Pattern  : Recursion

      Approach :
      Split and Recursive Reverse

      Idea :
      - Divide the linked list into
        odd-positioned and even-positioned
        nodes.
      - Reverse the even-positioned list
        recursively.
      - Attach the reversed even list
        to the end of the odd list.
      - The recursion is used only for
        reversing the even list.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void rearrange(Node head) {

        // Base Case
        if (head == null || head.next == null) {
            return;
        }

        // Separate Odd and Even Nodes
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        // Reverse Even List
        evenHead = reverse(evenHead);

        // Attach Reversed Even List
        odd.next = evenHead;
    }

    private Node reverse(Node head) {

        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        RearrangeLinkedListUsingRecursion obj =
                new RearrangeLinkedListUsingRecursion();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.print("Original List : ");
        printList(head);

        obj.rearrange(head);

        System.out.print("Rearranged List : ");
        printList(head);
    }
}