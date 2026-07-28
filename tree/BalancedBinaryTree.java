package tree;

public class BalancedBinaryTree {

    /*
      Platform : LeetCode

      Question : Balanced Binary Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Height Comparison

      Idea :
      - If the current node is
        null, return true.
      - Find the height of the
        left subtree.
      - Find the height of the
        right subtree.
      - If the height difference
        is greater than 1, the
        tree is not balanced.
      - Recursively check whether
        the left and right
        subtrees are balanced.

      Time Complexity :
      O(n²)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftHight =
                maxDepth(root.left);

        int rightHight =
                maxDepth(root.right);

        if (Math.abs(leftHight - rightHight) > 1) {
            return false;
        }

        return isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight =
                maxDepth(root.left);

        int rightHeight =
                maxDepth(root.right);

        return 1 + Math.max(leftHeight,
                            rightHeight);
    }

    public static void main(String[] args) {

        BalancedBinaryTree obj =
                new BalancedBinaryTree();

        TreeNode root =
                new TreeNode(3);

        root.left =
                new TreeNode(9);

        root.right =
                new TreeNode(20);

        root.right.left =
                new TreeNode(15);

        root.right.right =
                new TreeNode(7);

        boolean result =
                obj.isBalanced(root);

        System.out.println(
                "Is Balanced : " + result);
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