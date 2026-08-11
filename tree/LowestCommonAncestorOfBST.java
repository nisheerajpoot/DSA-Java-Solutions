package tree;

public class LowestCommonAncestorOfBST {

    /*
      Platform : LeetCode

      Question : Lowest Common Ancestor
                 of a Binary Search Tree

      Pattern  : Lowest Common Ancestor (LCA)
                 + Binary Search Tree (BST)

      Approach :
      BST Property

      Idea :
      - If both p and q are smaller
        than root, LCA is in the
        left subtree.
      - If both p and q are greater
        than root, LCA is in the
        right subtree.
      - Otherwise, current root is
        the Lowest Common Ancestor.
      - This works because in a BST:
          Left  < Root < Right

      Time Complexity :
      O(h)

      Space Complexity :
      O(h)

      (Recursive Call Stack)

      h = Height of the Tree
    */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (p.val < root.val&& q.val < root.val) {

            return lowestCommonAncestor(root.left,p,q);

        } else if (p.val > root.val&& q.val > root.val) {

            return lowestCommonAncestor(root.right, p,q);
        }

        return root;
    }

    public static void main(String[] args) {

        LowestCommonAncestorOfBST obj =
                new LowestCommonAncestorOfBST();

        TreeNode root =
                new TreeNode(6);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(8);

        root.left.left =
                new TreeNode(0);

        root.left.right =
                new TreeNode(4);

        root.left.right.left =
                new TreeNode(3);

        root.left.right.right =
                new TreeNode(5);

        root.right.left =
                new TreeNode(7);

        root.right.right =
                new TreeNode(9);

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