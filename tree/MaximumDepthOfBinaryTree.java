package tree;

public class MaximumDepthOfBinaryTree {

    /*
      Platform : LeetCode

      Question : Maximum Depth of Binary Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Depth Calculation

      Idea :
      - If the current node is
        null, return 0.
      - Recursively find the
        maximum depth of the
        left subtree.
      - Recursively find the
        maximum depth of the
        right subtree.
      - Return 1 plus the
        maximum of both depths.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftLevel =
                maxDepth(root.left);

        int rightLevel =
                maxDepth(root.right);

        return 1 + Math.max(leftLevel,
                            rightLevel);
    }

    public static void main(String[] args) {

        MaximumDepthOfBinaryTree obj =
                new MaximumDepthOfBinaryTree();

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
                obj.maxDepth(root);

        System.out.println(
                "Maximum Depth : " + result);
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