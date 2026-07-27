package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaryTreePostorderTraversal {

    /*
      Platform : LeetCode

      Question : N-ary Tree Postorder Traversal

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Postorder Traversal

      Idea :
      - If the current node is
        null, return an empty list.
      - Recursively traverse all
        the children from left
        to right.
      - Visit the root node after
        all children are processed.
      - Postorder follows the order:
        Children → Root.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<Integer> postorder(Node root) {

        List<Integer> arr = new ArrayList();

        if (root == null) {
            return arr;
        }

        for (Node n : root.children) {
            arr.addAll(postorder(n));
        }

        arr.add(root.val);

        return arr;
    }

    public static void main(String[] args) {

        NaryTreePostorderTraversal obj =
                new NaryTreePostorderTraversal();

        Node root = new Node(1);

        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        root.children = Arrays.asList(node3, node2, node4);
        node3.children = Arrays.asList(node5, node6);
        node2.children = new ArrayList<>();
        node4.children = new ArrayList<>();
        node5.children = new ArrayList<>();
        node6.children = new ArrayList<>();

        List<Integer> result =
                obj.postorder(root);

        System.out.println(
                "Postorder Traversal : " + result);
    }
}

class Node {

    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    public Node(int val,
                List<Node> children) {

        this.val = val;
        this.children = children;
    }
}