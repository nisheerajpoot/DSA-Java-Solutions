package linked_list_traversal;


public class DecimalEquivalentOfBinaryLinkedList {

    /*
      Platform : GeeksforGeeks
      Question : Decimal Equivalent of Binary Linked List

      Pattern  : Linked List Traversal

      Approach :
      Binary Number Construction

      Idea :
      - Traverse the linked list from left to right.
      - For every node:
            ans = ans * 2 + currentBit
      - This is exactly how binary is converted
        into decimal.


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

    public int decimalValue(Node head) {

        int ans = 0;
        int mod = 1000000007;

        while (head != null) {

            ans = (int) (((long) ans * 2 + head.data) % mod);

            head = head.next;
        }

        return ans;
    }

    public static void main(String[] args) {

        DecimalEquivalentOfBinaryLinkedList obj =
                new DecimalEquivalentOfBinaryLinkedList();

        // Binary Number = 1011

        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(1);
        head.next.next.next = new Node(1);

        int result = obj.decimalValue(head);

        System.out.println("Decimal Value = " + result);
    }
}