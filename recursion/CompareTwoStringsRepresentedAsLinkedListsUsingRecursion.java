package recursion;

public class CompareTwoStringsRepresentedAsLinkedListsUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Compare Two Strings Represented as Linked Lists

      Pattern  : Recursion

      Approach :
      Recursive Lexicographical Comparison

      Idea :
      - Compare the current characters
        of both linked lists.
      - If the characters are different,
        return:
          • 1  if first string is greater.
          • -1 if second string is greater.
      - If the characters are equal,
        recursively compare the remaining
        nodes.
      - If both lists end together,
        the strings are equal.
      - If one list ends before the other,
        the shorter string is considered
        smaller.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    static class Node {

        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    public int compare(Node head1, Node head2) {

        // Both strings are equal
        if (head1 == null && head2 == null) {
            return 0;
        }

        // First string is shorter
        if (head1 == null) {
            return -1;
        }

        // Second string is shorter
        if (head2 == null) {
            return 1;
        }

        // First string is greater
        if (head1.data > head2.data) {
            return 1;
        }

        // Second string is greater
        if (head1.data < head2.data) {
            return -1;
        }

        // Compare remaining characters
        return compare(head1.next, head2.next);
    }

    static Node createString(String str) {

        if (str.length() == 0) {
            return null;
        }

        Node head = new Node(str.charAt(0));
        Node curr = head;

        for (int i = 1; i < str.length(); i++) {

            curr.next = new Node(str.charAt(i));
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {

        CompareTwoStringsRepresentedAsLinkedListsUsingRecursion obj =
                new CompareTwoStringsRepresentedAsLinkedListsUsingRecursion();

        Node head1 = createString("apple");
        Node head2 = createString("apply");

        System.out.println(obj.compare(head1, head2));
    }
}
