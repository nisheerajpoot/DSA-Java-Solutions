package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    /*
      Platform : LeetCode

      Question : Binary Tree Zigzag Level Order Traversal

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive DFS with Zigzag
      Level Tracking

      Idea :
      - Traverse the tree using DFS.
      - Keep track of the current
        level during recursion.
      - If a new level is reached,
        create a new list.
      - For even levels, add the
        node at the end.
      - For odd levels, insert the
        node at the beginning.
      - Recursively traverse the
        left and right subtrees.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack +
       Result List)
    */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans =
                new ArrayList<>();

        dfs(root, 0, ans);

        return ans;
    }

    private void dfs(TreeNode root,
                     int level,
                     List<List<Integer>> ans) {

        if (root == null) {
            return;
        }

        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            ans.get(level).add(root.val);
        } else {
            ans.get(level).add(0, root.val);
        }

        dfs(root.left, level + 1, ans);
        dfs(root.right, level + 1, ans);
    }

    public static void main(String[] args) {

        BinaryTreeZigzagLevelOrderTraversal obj =
                new BinaryTreeZigzagLevelOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result =
                obj.zigzagLevelOrder(root);

        System.out.println(
                "Zigzag Level Order Traversal : " + result);
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