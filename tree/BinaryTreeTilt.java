package tree;

public class BinaryTreeTilt {

    /*
      Platform : LeetCode

      Question : Binary Tree Tilt

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Subtree Sum Calculation

      Idea :
      - Traverse the tree using DFS.
      - Calculate the sum of the
        left subtree.
      - Calculate the sum of the
        right subtree.
      - Tilt of the current node
        is the absolute difference
        between the left and right
        subtree sums.
      - Add the tilt to the final
        answer.
      - Return the subtree sum to
        the parent node.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    int ans = 0;

    public int findTilt(TreeNode root) {

        solve(root);

        return ans;
    }

    public int solve(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left =
                solve(root.left);

        int right =
                solve(root.right);

        ans += Math.abs(left - right);

        return root.val + left + right;
    }

    public static void main(String[] args) {

        BinaryTreeTilt obj =
                new BinaryTreeTilt();

        TreeNode root =
                new TreeNode(1);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(3);

        int result =
                obj.findTilt(root);

        System.out.println(
                "Binary Tree Tilt : " + result);
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