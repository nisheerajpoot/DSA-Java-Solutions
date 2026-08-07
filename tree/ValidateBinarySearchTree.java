package tree;

public class ValidateBinarySearchTree {

    /*
      Platform : LeetCode

      Question : Validate Binary Search Tree

      Pattern  : Binary Search Tree (BST)

      Approach :
      Recursive Range Validation

      Idea :
      - Every node in a BST must
        lie within a valid range.
      - Initially, the valid range
        is (-∞, +∞).
      - For the left subtree,
        update the maximum bound
        to the current node value.
      - For the right subtree,
        update the minimum bound
        to the current node value.
      - If any node violates the
        range, the tree is not a
        valid BST.

      Time Complexity :
      O(n)

      Space Complexity :
      O(h)

      (Recursive Call Stack)

      h = Height of the Tree
    */

    public boolean isValidBST(TreeNode root) {

        return check(root,
                     Long.MIN_VALUE,
                     Long.MAX_VALUE);
    }

    public boolean check(TreeNode root,
                         long min,
                         long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min
                || root.val >= max) {

            return false;
        }

        boolean left =
                check(root.left,
                      min,
                      root.val);

        boolean right =
                check(root.right,
                      root.val,
                      max);

        return left && right;
    }

    public static void main(String[] args) {

        ValidateBinarySearchTree obj =
                new ValidateBinarySearchTree();

        TreeNode root =
                new TreeNode(2);

        root.left =
                new TreeNode(1);

        root.right =
                new TreeNode(3);

        boolean result =
                obj.isValidBST(root);

        System.out.println(
                "Is Valid BST : " + result);
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