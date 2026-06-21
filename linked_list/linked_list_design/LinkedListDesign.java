package linked_list_design;


public class LinkedListDesign {

    /*
      Platform : LeetCode
      Question : Design Linked List
      Pattern  : Linked List Design

      Approach :
      Custom Singly Linked List Implementation

      Supported Operations :

      1. get(index)
      2. addAtHead(val)
      3. addAtTail(val)
      4. addAtIndex(index, val)
      5. deleteAtIndex(index)

      Time Complexity :

      get(index)          -> O(n)
      addAtHead(val)      -> O(1)
      addAtTail(val)      -> O(n)
      addAtIndex(index)   -> O(n)
      deleteAtIndex(index)-> O(n)

      Space Complexity :
      O(n)
      (For storing n nodes)
    */

    static class MyLinkedList {

        class Node {

            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        Node head;
        int size;

        public MyLinkedList() {

            head = null;
            size = 0;
        }

        public int get(int index) {

            if (index < 0 || index >= size) {
                return -1;
            }

            Node curr = head;

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            return curr.val;
        }

        public void addAtHead(int val) {

            Node newNode = new Node(val);

            newNode.next = head;
            head = newNode;

            size++;
        }

        public void addAtTail(int val) {

            Node newNode = new Node(val);

            if (head == null) {

                head = newNode;
                size++;
                return;
            }

            Node curr = head;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = newNode;

            size++;
        }

        public void addAtIndex(int index, int val) {

            if (index < 0 || index > size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
                return;
            }

            Node prev = head;

            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            Node newNode = new Node(val);

            newNode.next = prev.next;
            prev.next = newNode;

            size++;
        }

        public void deleteAtIndex(int index) {

            if (index < 0 || index >= size) {
                return;
            }

            if (index == 0) {

                head = head.next;
                size--;
                return;
            }

            Node prev = head;

            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            prev.next = prev.next.next;

            size--;
        }

        public void display() {

            Node curr = head;

            while (curr != null) {

                System.out.print(curr.val);

                if (curr.next != null) {
                    System.out.print(" -> ");
                }

                curr = curr.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addAtHead(10);
        list.addAtHead(5);
        list.addAtTail(20);
        list.addAtTail(30);

        System.out.println("Linked List:");
        list.display();

        System.out.println("\nValue at Index 2 : "
                + list.get(2));

        list.addAtIndex(2, 15);

        System.out.println("\nAfter addAtIndex(2, 15):");
        list.display();

        list.deleteAtIndex(3);

        System.out.println("\nAfter deleteAtIndex(3):");
        list.display();

        System.out.println("\nCurrent Size : "
                + list.size);
    }
}