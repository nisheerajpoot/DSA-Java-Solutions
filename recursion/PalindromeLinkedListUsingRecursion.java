package recursion;

public class PalindromeLinkedListUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Palindrome Linked List

      Pattern  : Recursion

      Approach :
      Two Pointer using Recursion

      Idea :
      - Maintain one pointer (left)
        starting from the head.
      - Recursively move another pointer
        (right) to the end of the list.
      - While returning from recursion,
        compare the current right node
        with the left node.
      - If any pair of values differs,
        return false.
      - After every successful comparison,
        move the left pointer forward.
      - If all corresponding nodes match,
        the linked list is a palindrome.

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

    Node left;

    public boolean isPalindrome(Node head) {

        left = head;

        return check(head);
    }

    private boolean check(Node right) {

        // Base Case
        if (right == null) {
            return true;
        }

        // Traverse to the end
        if (!check(right.next)) {
            return false;
        }

        // Compare left and right nodes
        if (left.data != right.data) {
            return false;
        }

        // Move left pointer forward
        left = left.next;

        return true;
    }

    static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        PalindromeLinkedListUsingRecursion obj =
                new PalindromeLinkedListUsingRecursion();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.print("Linked List : ");
        printList(head);

        System.out.println("Is Palindrome : " +
                obj.isPalindrome(head));
    }
}