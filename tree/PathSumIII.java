package tree;

public class PathSumIII {

    /*
      Platform : LeetCode

      Question : Path Sum III

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive DFS from Every Node

      Idea :
      - Traverse every node in
        the tree.
      - Treat every node as the
        starting point of a path.
      - From each node, perform
        DFS while maintaining the
        current path sum.
      - If the current sum equals
        the target sum, increase
        the answer.
      - Continue searching in the
        left and right subtrees.

      Time Complexity :
      O(n²)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    int ans = 0;

    public int pathSum(TreeNode root,
                       int targetSum) {

        if (root == null) {
            return 0;
        }

        findPath(root,
                 targetSum,
                 0);

        pathSum(root.left,
                targetSum);

        pathSum(root.right,
                targetSum);

        return ans;
    }

    public void findPath(TreeNode root,
                         int targetSum,
                         long currSum) {

        if (root == null) {
            return;
        }

        currSum += root.val;

        if (currSum == targetSum) {
            ans++;
        }

        findPath(root.left,
                 targetSum,
                 currSum);

        findPath(root.right,
                 targetSum,
                 currSum);
    }

    public static void main(String[] args) {

        PathSumIII obj =
                new PathSumIII();

        TreeNode root =
                new TreeNode(10);

        root.left =
                new TreeNode(5);

        root.right =
                new TreeNode(-3);

        root.left.left =
                new TreeNode(3);

        root.left.right =
                new TreeNode(2);

        root.right.right =
                new TreeNode(11);

        root.left.left.left =
                new TreeNode(3);

        root.left.left.right =
                new TreeNode(-2);

        root.left.right.right =
                new TreeNode(1);

        int targetSum = 8;

        int result =
                obj.pathSum(root,
                            targetSum);

        System.out.println(
                "Total Paths : " + result);
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