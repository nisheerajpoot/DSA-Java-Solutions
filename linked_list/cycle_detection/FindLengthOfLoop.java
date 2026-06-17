package cycle_detection;

public class FindLengthOfLoop {

    /*
      Platform : GeeksforGeeks
      Question : Find Length of Loop
      Pattern  : Cycle Detection (Floyd's Algorithm)

      Approach :
      Slow and Fast Pointer

      Idea :
      - Use two pointers:
          slow -> moves 1 step
          fast -> moves 2 steps
      - If slow and fast meet,
        a loop exists.
      - From the meeting point,
        traverse the loop once and
        count the number of nodes.
      - Return the count as the
        length of the loop.
      - If no loop exists,
        return 0.

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
            this.next = null;
        }
    }

    public int lengthOfLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                int count = 1;
                Node temp = slow.next;

                while (temp != slow) {

                    count++;
                    temp = temp.next;
                }

                return count;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        FindLengthOfLoop obj = new FindLengthOfLoop();


        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.next.next.next.next.next = head.next.next;

        int length = obj.lengthOfLoop(head);

        System.out.println("Length of Loop : " + length);
    }
}