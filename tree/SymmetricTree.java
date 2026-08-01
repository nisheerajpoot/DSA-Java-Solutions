package tree;

public class SymmetricTree {

    /*
      Platform : LeetCode

      Question : Symmetric Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Mirror Comparison

      Idea :
      - If the root is null,
        return false.
      - Compare the left and
        right subtrees.
      - If both nodes are null,
        they are symmetric.
      - If one node is null or
        values are different,
        return false.
      - Recursively compare:
        Left.Left with Right.Right
        and
        Left.Right with Right.Left.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        return mirror(root.left,
                      root.right);
    }

    public boolean mirror(TreeNode left,
                          TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return mirror(left.left,
                      right.right)
                && mirror(left.right,
                          right.left);
    }

    public static void main(String[] args) {

        SymmetricTree obj =
                new SymmetricTree();

        TreeNode root =
                new TreeNode(1);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(2);

        root.left.left =
                new TreeNode(3);

        root.left.right =
                new TreeNode(4);

        root.right.left =
                new TreeNode(4);

        root.right.right =
                new TreeNode(3);

        boolean result =
                obj.isSymmetric(root);

        System.out.println(
                "Is Symmetric : " + result);
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