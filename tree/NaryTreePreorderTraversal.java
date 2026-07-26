package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaryTreePreorderTraversal {

    /*
      Platform : LeetCode

      Question : N-ary Tree Preorder Traversal

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Preorder Traversal

      Idea :
      - If the current node is
        null, return an empty list.
      - Visit the root node first.
      - Traverse all the children
        from left to right.
      - Repeat the same process
        recursively for every child.
      - Preorder follows the order:
        Root → Children.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<Integer> preorder(Node root) {

        List<Integer> preTra = new ArrayList<>();

        if (root == null) {
            return preTra;
        }

        preTra.add(root.val);

        for (Node child : root.children) {
            preTra.addAll(preorder(child));
        }

        return preTra;
    }

    public static void main(String[] args) {

        NaryTreePreorderTraversal obj =
                new NaryTreePreorderTraversal();

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
                obj.preorder(root);

        System.out.println(
                "Preorder Traversal : " + result);
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