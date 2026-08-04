package tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    /*
      Platform : LeetCode

      Question : Leaf-Similar Trees

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Leaf Collection

      Idea :
      - Traverse both trees using
        DFS.
      - Collect all leaf node
        values in separate lists.
      - A node is a leaf if both
        left and right children
        are null.
      - Compare both leaf
        sequences.
      - If both lists are equal,
        the trees are leaf-similar.

      Time Complexity :
      O(n + m)

      Space Complexity :
      O(n + m)

      (Recursive Call Stack +
       Leaf Lists)
    */

    public boolean leafSimilar(TreeNode root1,
                               TreeNode root2) {

        List<Integer> list1 =
                new ArrayList<>();

        List<Integer> list2 =
                new ArrayList<>();

        dfs(root1, list1);

        dfs(root2, list2);

        return list1.equals(list2);
    }

    public void dfs(TreeNode root,
                    List<Integer> list) {

        if (root == null) {
            return;
        }

        if (root.left == null
                && root.right == null) {

            list.add(root.val);

            return;
        }

        dfs(root.left, list);

        dfs(root.right, list);
    }

    public static void main(String[] args) {

        LeafSimilarTrees obj =
                new LeafSimilarTrees();

        TreeNode root1 =
                new TreeNode(3);

        root1.left =
                new TreeNode(5);

        root1.right =
                new TreeNode(1);

        root1.left.left =
                new TreeNode(6);

        root1.left.right =
                new TreeNode(2);

        root1.right.left =
                new TreeNode(9);

        root1.right.right =
                new TreeNode(8);

        TreeNode root2 =
                new TreeNode(3);

        root2.left =
                new TreeNode(5);

        root2.right =
                new TreeNode(1);

        root2.left.left =
                new TreeNode(6);

        root2.left.right =
                new TreeNode(7);

        root2.right.left =
                new TreeNode(4);

        root2.right.right =
                new TreeNode(8);

        boolean result =
                obj.leafSimilar(root1, root2);

        System.out.println(
                "Leaf Similar : " + result);
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