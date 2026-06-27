package recursion_pattern;

public class SearchInLinkedListUsingRecursion {

    /*
      Platform : GeeksforGeeks

      Question : Search in Linked List

      Pattern  : Recursion

      Approach :
      Recursive Search

      Idea :
      - Check the current node.
      - If the current node is null,
        the key is not present.
      - If the current node contains the key,
        return true.
      - Otherwise, recursively search
        in the remaining linked list.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

    */

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public boolean searchKey(Node head, int key) {

        // Base Case : Key not found
        if (head == null) {
            return false;
        }

        // Base Case : Key found
        if (head.data == key) {
            return true;
        }

        // Search in remaining list
        return searchKey(head.next, key);
    }

    public static void main(String[] args) {

        SearchInLinkedListUsingRecursion obj =
                new SearchInLinkedListUsingRecursion();

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println(obj.searchKey(head, 30)); // true
        System.out.println(obj.searchKey(head, 50)); // false
    }
}