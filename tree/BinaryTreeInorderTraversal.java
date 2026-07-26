package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    /*
      Platform : LeetCode

      Question : Binary Tree Inorder Traversal

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Inorder Traversal

      Idea :
      - If the current node is
        null, return an empty list.
      - Recursively traverse the
        left subtree.
      - Visit the root node.
      - Recursively traverse the
        right subtree.
      - Inorder follows the order:
        Left → Root → Right.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inTra = new ArrayList<>();

        if (root == null) {
            return inTra;
        }

        inTra.addAll(inorderTraversal(root.left));
        inTra.add(root.val);
        inTra.addAll(inorderTraversal(root.right));

        return inTra;
    }

    public static void main(String[] args) {

        BinaryTreeInorderTraversal obj =
                new BinaryTreeInorderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result =
                obj.inorderTraversal(root);

        System.out.println(
                "Inorder Traversal : " + result);
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