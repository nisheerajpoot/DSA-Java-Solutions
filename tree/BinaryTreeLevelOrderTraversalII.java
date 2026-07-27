package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    /*
      Platform : LeetCode

      Question : Binary Tree Level Order Traversal II

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive DFS with Bottom-Up
      Level Tracking

      Idea :
      - Traverse the tree using DFS.
      - Keep track of the current
        level during recursion.
      - If a new level is reached,
        insert an empty list at the
        beginning of the result.
      - Calculate the correct index
        from the bottom.
      - Add the current node to its
        corresponding level.
      - Recursively traverse the
        left and right subtrees.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack +
       Result List)
    */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list =
                new ArrayList<>();

        dfs(root, 0, list);

        return list;
    }

    private void dfs(TreeNode root,
                     int level,
                     List<List<Integer>> list) {

        if (root == null) {
            return;
        }

        if (level == list.size()) {
            list.add(0, new ArrayList<>());
        }

        int index = list.size() - level - 1;

        list.get(index).add(root.val);

        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversalII obj =
                new BinaryTreeLevelOrderTraversalII();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result =
                obj.levelOrderBottom(root);

        System.out.println(
                "Bottom-Up Level Order Traversal : " + result);
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