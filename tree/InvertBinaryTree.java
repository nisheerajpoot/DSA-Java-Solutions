package tree;

public class InvertBinaryTree {

    /*
      Platform : LeetCode

      Question : Invert Binary Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Tree Inversion

      Idea :
      - If the current node is
        null, return null.
      - Recursively invert the
        left subtree.
      - Recursively invert the
        right subtree.
      - Swap the left and right
        child of the current node.
      - Return the root of the
        inverted tree.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left =
                invertTree(root.left);

        TreeNode right =
                invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {

        InvertBinaryTree obj =
                new InvertBinaryTree();

        TreeNode root =
                new TreeNode(4);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(7);

        root.left.left =
                new TreeNode(1);

        root.left.right =
                new TreeNode(3);

        root.right.left =
                new TreeNode(6);

        root.right.right =
                new TreeNode(9);

        TreeNode result =
                obj.invertTree(root);

        System.out.println(
                "Root After Inversion : " + result.val);

        System.out.println(
                "Left Child : " + result.left.val);

        System.out.println(
                "Right Child : " + result.right.val);
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