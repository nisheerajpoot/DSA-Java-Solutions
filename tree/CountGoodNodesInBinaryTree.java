package tree;

public class CountGoodNodesInBinaryTree {

    /*
      Platform : LeetCode

      Question : Count Good Nodes in Binary Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive DFS with Maximum
      Value Tracking

      Idea :
      - Traverse the tree using DFS.
      - Keep track of the maximum
        value seen from the root
        to the current node.
      - If the current node value
        is greater than or equal
        to the maximum value,
        count it as a good node.
      - Update the maximum value.
      - Recursively process the
        left and right subtrees.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    int goodNode = 0;

    public int goodNodes(TreeNode root) {

        solve(root, root.val);

        return goodNode;
    }

    public int solve(TreeNode root,
                     int max) {

        if (root == null) {
            return 0;
        }

        int m =
                Math.max(max, root.val);

        if (root.val >= max) {
            goodNode++;
        }

        solve(root.left, m);

        solve(root.right, m);

        return goodNode;
    }

    public static void main(String[] args) {

        CountGoodNodesInBinaryTree obj =
                new CountGoodNodesInBinaryTree();

        TreeNode root =
                new TreeNode(3);

        root.left =
                new TreeNode(1);

        root.right =
                new TreeNode(4);

        root.left.left =
                new TreeNode(3);

        root.right.left =
                new TreeNode(1);

        root.right.right =
                new TreeNode(5);

        int result =
                obj.goodNodes(root);

        System.out.println(
                "Good Nodes : " + result);
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