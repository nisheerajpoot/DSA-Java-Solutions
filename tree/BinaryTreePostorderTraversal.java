package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    /*
      Platform : LeetCode

      Question : Binary Tree Postorder Traversal

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Postorder Traversal

      Idea :
      - If the current node is
        null, return an empty list.
      - Recursively traverse the
        left subtree.
      - Recursively traverse the
        right subtree.
      - Visit the root node.
      - Postorder follows the order:
        Left → Right → Root.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> postTra = new ArrayList<>();

        if (root == null) {
            return postTra;
        }

        postTra.addAll(postorderTraversal(root.left));
        postTra.addAll(postorderTraversal(root.right));
        postTra.add(root.val);

        return postTra;
    }

    public static void main(String[] args) {

        BinaryTreePostorderTraversal obj =
                new BinaryTreePostorderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result =
                obj.postorderTraversal(root);

        System.out.println(
                "Postorder Traversal : " + result);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val,
             TreeNode left,
             TreeNode right) {

        this.val = val;
        this.left = left;
        this.right = right;
    }
}