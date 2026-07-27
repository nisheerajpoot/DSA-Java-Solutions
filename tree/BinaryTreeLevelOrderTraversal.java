package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    /*
      Platform : LeetCode

      Question : Binary Tree Level Order Traversal

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive DFS with Level Tracking

      Idea :
      - Traverse the tree using DFS.
      - Keep track of the current
        level during recursion.
      - If the current level does
        not exist in the result,
        create a new list.
      - Add the current node to
        its corresponding level.
      - Recursively traverse the
        left and right subtrees.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack +
       Result List)
    */

    public List<List<Integer>> levelOrder(TreeNode root) {

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
            list.add(new ArrayList<>());
        }

        list.get(level).add(root.val);

        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal obj =
                new BinaryTreeLevelOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result =
                obj.levelOrder(root);

        System.out.println(
                "Level Order Traversal : " + result);
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