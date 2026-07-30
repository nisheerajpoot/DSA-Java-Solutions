package tree;

public class LongestUnivaluePath {

    /*
      Platform : LeetCode

      Question : Longest Univalue Path

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Path Calculation

      Idea :
      - Traverse the tree using DFS.
      - Calculate the longest path
        from the left subtree.
      - Calculate the longest path
        from the right subtree.
      - Extend the path only if the
        child has the same value as
        the current node.
      - Update the maximum path
        using both left and right
        arrows.
      - Return the longer arrow
        length to the parent.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {

        longPath(root);

        return ans;
    }

    public int longPath(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left =
                longPath(root.left);

        int right =
                longPath(root.right);

        int leftArrow = 0;
        int rightArrow = 0;

        if (root.left != null
                && root.left.val == root.val) {

            leftArrow = left + 1;
        }

        if (root.right != null
                && root.right.val == root.val) {

            rightArrow = right + 1;
        }

        ans = Math.max(ans,
                leftArrow + rightArrow);

        return Math.max(leftArrow,
                        rightArrow);
    }

    public static void main(String[] args) {

        LongestUnivaluePath obj =
                new LongestUnivaluePath();

        TreeNode root =
                new TreeNode(5);

        root.left =
                new TreeNode(4);

        root.right =
                new TreeNode(5);

        root.left.left =
                new TreeNode(1);

        root.left.right =
                new TreeNode(1);

        root.right.right =
                new TreeNode(5);

        int result =
                obj.longestUnivaluePath(root);

        System.out.println(
                "Longest Univalue Path : " + result);
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