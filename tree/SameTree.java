package tree;

public class SameTree {

    /*
      Platform : LeetCode

      Question : Same Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Tree Comparison

      Idea :
      - If both nodes are null,
        the trees are identical.
      - If one node is null and
        the other is not, the
        trees are different.
      - If the values of the
        current nodes are not
        equal, return false.
      - Recursively compare the
        left subtrees.
      - Recursively compare the
        right subtrees.
      - Both left and right
        comparisons must be true.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    public boolean isSameTree(TreeNode p,
                              TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        SameTree obj =
                new SameTree();

        TreeNode p =
                new TreeNode(1);

        p.left =
                new TreeNode(2);

        p.right =
                new TreeNode(3);

        TreeNode q =
                new TreeNode(1);

        q.left =
                new TreeNode(2);

        q.right =
                new TreeNode(3);

        boolean result =
                obj.isSameTree(p, q);

        System.out.println(
                "Is Same Tree : " + result);
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