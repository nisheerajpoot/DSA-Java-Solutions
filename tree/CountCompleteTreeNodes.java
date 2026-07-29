package tree;

public class CountCompleteTreeNodes {

    /*
      Platform : LeetCode

      Question : Count Complete Tree Nodes

      Pattern  : Complete Binary Tree

      Approach :
      Height Comparison

      Idea :
      - Find the height of the
        leftmost path.
      - Find the height of the
        rightmost path.
      - If both heights are equal,
        the tree is a perfect
        binary tree.
      - Count the nodes directly
        using the formula:
        (2^height) - 1.
      - Otherwise, recursively
        count nodes in the left
        and right subtrees.

      Time Complexity :
      O(log²n)

      Space Complexity :
      O(logn)

      (Recursive Call Stack)
    */

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight =
                leftHeight(root);

        int rightHeight =
                rightHeight(root);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1
                + countNodes(root.left)
                + countNodes(root.right);
    }

    public int leftHeight(TreeNode root) {

        int height = 0;

        while (root != null) {

            height++;

            root = root.left;
        }

        return height;
    }

    public int rightHeight(TreeNode root) {

        int height = 0;

        while (root != null) {

            height++;

            root = root.right;
        }

        return height;
    }

    public static void main(String[] args) {

        CountCompleteTreeNodes obj =
                new CountCompleteTreeNodes();

        TreeNode root =
                new TreeNode(1);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(3);

        root.left.left =
                new TreeNode(4);

        root.left.right =
                new TreeNode(5);

        root.right.left =
                new TreeNode(6);

        int result =
                obj.countNodes(root);

        System.out.println(
                "Total Nodes : " + result);
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