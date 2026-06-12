package dummy_node_pattern;

import java.util.Scanner;

public class AddTwoNumbers {

    /*
      Platform : LeetCode
      Question : Add Two Numbers
      Pattern  : Dummy Node Pattern

      Approach :
      Dummy Node + Carry Handling

      Idea :
      - Traverse both linked lists simultaneously.
      - Add corresponding digits and carry.
      - Create a new node containing sum % 10.
      - Update carry = sum / 10.
      - Continue until both lists and carry are exhausted.

      Time Complexity :
      O(max(n, m))

      Space Complexity :
      O(max(n, m))
    */

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            temp.next = new ListNode(sum % 10);

            temp = temp.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AddTwoNumbers obj = new AddTwoNumbers();

        System.out.print("Enter size of first list: ");
        int n1 = sc.nextInt();

        ListNode l1 = null;
        ListNode temp1 = null;

        if (n1 > 0) {

            System.out.println("Enter first number digits:");

            l1 = new ListNode(sc.nextInt());
            temp1 = l1;

            for (int i = 1; i < n1; i++) {

                temp1.next = new ListNode(sc.nextInt());
                temp1 = temp1.next;
            }
        }

        System.out.print("Enter size of second list: ");
        int n2 = sc.nextInt();

        ListNode l2 = null;
        ListNode temp2 = null;

        if (n2 > 0) {

            System.out.println("Enter second number digits:");

            l2 = new ListNode(sc.nextInt());
            temp2 = l2;

            for (int i = 1; i < n2; i++) {

                temp2.next = new ListNode(sc.nextInt());
                temp2 = temp2.next;
            }
        }

        ListNode ans = obj.addTwoNumbers(l1, l2);

        System.out.print("Result List : ");
        printList(ans);

        sc.close();
    }
}