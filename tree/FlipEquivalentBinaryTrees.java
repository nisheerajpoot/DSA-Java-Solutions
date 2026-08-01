package tree;

public class FlipEquivalentBinaryTrees {

    /*
      Platform : LeetCode

      Question : Flip Equivalent Binary Trees

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Tree Comparison

      Idea :
      - If both nodes are null,
        return true.
      - If one node is null or
        values are different,
        return false.
      - Check both possibilities:
        without flipping and
        with flipping.
      - If either comparison
        returns true, the trees
        are flip equivalent.

      Time Complexity :
      O(n)

      Space Complexity :
      O(h)

      (Recursive Call Stack)
    */

    public boolean flipEquiv(TreeNode root1,
                             TreeNode root2) {

        return check(root1, root2);
    }

    public boolean check(TreeNode p,
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

        boolean noFlip =
                check(p.left, q.left)
                && check(p.right, q.right);

        boolean flip =
                check(p.left, q.right)
                && check(p.right, q.left);

        return noFlip || flip;
    }

    public static void main(String[] args) {

        FlipEquivalentBinaryTrees obj =
                new FlipEquivalentBinaryTrees();

        TreeNode root1 =
                new TreeNode(1);

        root1.left =
                new TreeNode(2);

        root1.right =
                new TreeNode(3);

        root1.left.left =
                new TreeNode(4);

        root1.left.right =
                new TreeNode(5);

        TreeNode root2 =
                new TreeNode(1);

        root2.left =
                new TreeNode(3);

        root2.right =
                new TreeNode(2);

        root2.right.left =
                new TreeNode(5);

        root2.right.right =
                new TreeNode(4);

        boolean result =
                obj.flipEquiv(root1, root2);

        System.out.println(
                "Flip Equivalent : " + result);
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