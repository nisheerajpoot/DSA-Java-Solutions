package divide_and_conquer;

public class FlattenAMultilevelDoublyLinkedList {

    /*
      Platform : LeetCode
      Question : Flatten a Multilevel Doubly Linked List
      Pattern  : Divide and Conquer

      Approach :
      DFS (Depth First Search)

      Idea :
      - Traverse the current level.
      - Whenever a child list is found:
          1. Flatten the child list recursively.
          2. Insert the child list between
             current node and next node.
          3. Connect child tail with next node.
          4. Remove child pointer.
      - Return the tail of the flattened list.

      Time Complexity :
      O(n)

      Space Complexity :
      O(d)

      d = maximum depth of multilevel list
      (Recursive Call Stack)
    */

    static class Node {

        int val;
        Node prev;
        Node next;
        Node child;

        Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        flattenDFS(head);

        return head;
    }

    public static Node flattenDFS(Node head) {

        Node curr = head;
        Node last = head;

        while (curr != null) {

            Node next = curr.next;

            if (curr.child != null) {

                Node childHead = curr.child;

                Node childTail = flattenDFS(childHead);

                curr.next = childHead;
                childHead.prev = curr;

                if (next != null) {

                    childTail.next = next;
                    next.prev = childTail;
                }

                curr.child = null;

                last = childTail;

                curr = childTail;
            }
            else {

                last = curr;
            }

            curr = curr.next;
        }

        return last;
    }

    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        FlattenAMultilevelDoublyLinkedList obj =
                new FlattenAMultilevelDoublyLinkedList();

        /*
                 1 - 2 - 3 - 4 - 5 - 6
                         |
                         7 - 8 - 9 - 10
                             |
                             11 - 12
        */

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        n4.next = n5;
        n5.prev = n4;

        n5.next = n6;
        n6.prev = n5;

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n7.next = n8;
        n8.prev = n7;

        n8.next = n9;
        n9.prev = n8;

        n9.next = n10;
        n10.prev = n9;

        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n11.next = n12;
        n12.prev = n11;

        n3.child = n7;
        n8.child = n11;

        Node head = obj.flatten(n1);

        System.out.println("Flattened List:");
        printList(head);
    }
}