package tree;

public class LowestCommonAncestor {

    /*
      Platform : LeetCode

      Question : Lowest Common Ancestor
                  of a Binary Tree

      Pattern  : Lowest Common Ancestor (LCA)

      Approach :
      Recursive DFS

      Idea :
      - If root is null, return null.
      - If root is either p or q,
        return root.
      - Recursively search for p and q
        in the left and right subtrees.
      - If both left and right return
        a node, current root is the
        Lowest Common Ancestor.
      - Otherwise, return whichever
        side contains a node.

      Time Complexity :
      O(n)

      Space Complexity :
      O(h)

      (Recursive Call Stack)

      h = Height of the Tree
    */

    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p,
                                         TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left =
                lowestCommonAncestor(root.left,
                                     p,
                                     q);

        TreeNode right =
                lowestCommonAncestor(root.right,
                                     p,
                                     q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {

        LowestCommonAncestor obj =
                new LowestCommonAncestor();

        TreeNode root =
                new TreeNode(3);

        root.left =
                new TreeNode(5);

        root.right =
                new TreeNode(1);

        root.left.left =
                new TreeNode(6);

        root.left.right =
                new TreeNode(2);

        root.right.left =
                new TreeNode(0);

        root.right.right =
                new TreeNode(8);

        TreeNode p =
                root.left;

        TreeNode q =
                root.right;

        TreeNode result =
                obj.lowestCommonAncestor(root,
                                         p,
                                         q);

        System.out.println(
                "Lowest Common Ancestor : "
                        + result.val);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}