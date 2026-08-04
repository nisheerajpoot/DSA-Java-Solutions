package tree;

public class PathSum {

    /*
      Platform : LeetCode

      Question : Path Sum

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Path Sum Check

      Idea :
      - Traverse the tree using
        DFS.
      - Keep adding the current
        node value to the path sum.
      - When a leaf node is reached,
        compare the current sum with
        the target sum.
      - If they are equal, return
        true.
      - Otherwise, recursively
        check the left and right
        subtrees.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public boolean hasPathSum(TreeNode root,
                              int targetSum) {

        if (root == null) {
            return false;
        }

        return check(root,
                     targetSum,
                     0);
    }

    public boolean check(TreeNode root,
                         int targetSum,
                         int currSum) {

        if (root == null) {
            return false;
        }

        currSum = currSum + root.val;

        if (root.left == null
                && root.right == null) {

            return currSum == targetSum;
        }

        boolean left =
                check(root.left,
                      targetSum,
                      currSum);

        boolean right =
                check(root.right,
                      targetSum,
                      currSum);

        return left || right;
    }

    public static void main(String[] args) {

        PathSum obj =
                new PathSum();

        TreeNode root =
                new TreeNode(5);

        root.left =
                new TreeNode(4);

        root.right =
                new TreeNode(8);

        root.left.left =
                new TreeNode(11);

        root.left.left.left =
                new TreeNode(7);

        root.left.left.right =
                new TreeNode(2);

        root.right.left =
                new TreeNode(13);

        root.right.right =
                new TreeNode(4);

        root.right.right.right =
                new TreeNode(1);

        int targetSum = 22;

        boolean result =
                obj.hasPathSum(root,
                               targetSum);

        System.out.println(
                "Has Path Sum : " + result);
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