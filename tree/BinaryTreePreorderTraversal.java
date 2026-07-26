package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    /*
      Platform : LeetCode

      Question : Binary Tree Preorder Traversal

      Pattern  : DFS (Preorder)

      Approach :
      Recursive Traversal

      Idea :
      - Visit Root.
      - Traverse Left.
      - Traverse Right.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)
    */

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> preTra = new ArrayList<>();

        if (root == null) {
            return preTra;
        }

        preTra.add(root.val);
        preTra.addAll(preorderTraversal(root.left));
        preTra.addAll(preorderTraversal(root.right));

        return preTra;
    }

    public static void main(String[] args) {

        BinaryTreePreorderTraversal obj =
                new BinaryTreePreorderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result =
                obj.preorderTraversal(root);

        System.out.println(result);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

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