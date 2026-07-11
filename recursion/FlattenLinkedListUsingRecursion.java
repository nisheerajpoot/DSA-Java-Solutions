package recursion;

public class FlattenLinkedListUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Flattening a Linked List

      Pattern  : Recursion

      Approach :
      Recursive Merge

      Idea :
      - Recursively flatten the linked
        list starting from the last node.
      - Flatten the remaining list
        connected through next pointers.
      - Merge the current bottom list
        with the already flattened list.
      - Merge is performed recursively
        using the bottom pointers.
      - The next pointers are removed,
        leaving only a single sorted
        bottom linked list.

      Time Complexity :
      O(N × M)

      where:
      N = Number of linked lists
      M = Average number of nodes
          in each bottom list

      Space Complexity :
      O(N)

      (Recursive Call Stack)
    */

    static class Node {

        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
        }
    }

    public Node flatten(Node root) {

        // Base Case
        if (root == null || root.next == null) {
            return root;
        }

        // Flatten Remaining Lists
        root.next = flatten(root.next);

        // Merge Current List
        return merge(root, root.next);
    }

    private Node merge(Node first,
                       Node second) {

        // Base Cases
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        Node result;

        // Merge Recursively
        if (first.data <= second.data) {

            result = first;

            result.bottom = merge(first.bottom, second);

        } else {

            result = second;

            result.bottom = merge(first, second.bottom);
        }

        // Remove next pointer
        result.next = null;

        return result;
    }

    static void printBottom(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");

            head = head.bottom;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        FlattenLinkedListUsingRecursion obj =
                new FlattenLinkedListUsingRecursion();

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        head = obj.flatten(head);

        System.out.print("Flattened List : ");
        printBottom(head);
    }
}