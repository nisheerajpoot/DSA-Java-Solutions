package tree;

public class BinaryTreeMaximumPathSum {

    /*
      Platform : LeetCode

      Question : Binary Tree Maximum Path Sum

      Pattern  : Height / Return from Children

      Approach :
      Recursive DFS

      Idea :
      - Recursively find the maximum
        path contribution from the
        left and right subtrees.
      - If a subtree returns a
        negative value, ignore it
        by taking maximum with 0.
      - Calculate the current path
        using:

        left + root.val + right

      - Update maxSum with the
        maximum path found so far.
      - Return the current node
        value with only one maximum
        child path because the parent
        cannot take both sides.

      Time Complexity :
      O(n)

      Space Complexity :
      O(h)

      (Recursive Call Stack)

      h = Height of the Tree
    */

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        solve(root);

        return maxSum;
    }

    public int solve(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left =
                solve(root.left);

        int right =
                solve(root.right);

        left =
                Math.max(0, left);

        right =
                Math.max(0, right);

        int currentPath =
                left + root.val + right;

        maxSum =
                Math.max(maxSum,
                         currentPath);

        return root.val +
                Math.max(left, right);
    }

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum obj =
                new BinaryTreeMaximumPathSum();

        TreeNode root =
                new TreeNode(-10);

        root.left =
                new TreeNode(9);

        root.right =
                new TreeNode(20);

        root.right.left =
                new TreeNode(15);

        root.right.right =
                new TreeNode(7);

        int result =
                obj.maxPathSum(root);

        System.out.println(
                "Maximum Path Sum : " + result);
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