package tree;

public class MinimumDepthOfBinaryTree {

    /*
      Platform : LeetCode

      Question : Minimum Depth of Binary Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Depth Calculation

      Idea :
      - If the current node is
        null, return 0.
      - Recursively find the
        minimum depth of the
        left subtree.
      - Recursively find the
        minimum depth of the
        right subtree.
      - If one child is null,
        return the depth of the
        non-null child.
      - Otherwise, return 1 plus
        the minimum of both depths.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftnode =
                minDepth(root.left);

        int rightnode =
                minDepth(root.right);

        if (root.left == null) {
            return 1 + rightnode;
        } else if (root.right == null) {
            return 1 + leftnode;
        }

        return 1 + Math.min(leftnode,
                            rightnode);
    }

    public static void main(String[] args) {

        MinimumDepthOfBinaryTree obj =
                new MinimumDepthOfBinaryTree();

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

        int result =
                obj.minDepth(root);

        System.out.println(
                "Minimum Depth : " + result);
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