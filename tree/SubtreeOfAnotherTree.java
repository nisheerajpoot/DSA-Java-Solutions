package tree;

public class SubtreeOfAnotherTree {

    /*
      Platform : LeetCode

      Question : Subtree of Another Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Tree Comparison

      Idea :
      - Traverse the main tree.
      - At every node, compare the
        current subtree with the
        given subtree.
      - If both trees are the same,
        return true.
      - Otherwise, recursively
        search in the left and
        right subtrees.
      - Two trees are identical if
        their structure and node
        values are the same.

      Time Complexity :
      O(m × n)

      Space Complexity :
      O(h)

      (Recursive Call Stack)
    */

    public boolean isSubtree(TreeNode root,
                             TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        // Check Current Subtree
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Search Left or Right Subtree
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p,
                              TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        SubtreeOfAnotherTree obj =
                new SubtreeOfAnotherTree();

        TreeNode root =
                new TreeNode(3);

        root.left =
                new TreeNode(4);

        root.right =
                new TreeNode(5);

        root.left.left =
                new TreeNode(1);

        root.left.right =
                new TreeNode(2);

        TreeNode subRoot =
                new TreeNode(4);

        subRoot.left =
                new TreeNode(1);

        subRoot.right =
                new TreeNode(2);

        boolean result =
                obj.isSubtree(root, subRoot);

        System.out.println(
                "Is Subtree : " + result);
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