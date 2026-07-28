package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    /*
      Platform : LeetCode

      Question : Binary Tree Right Side View

      Pattern  : Tree Traversal (BFS)

      Approach :
      Level Order Traversal

      Idea :
      - Traverse the tree level
        by level using a queue.
      - At each level, identify
        the last node.
      - Add the last node's value
        to the result.
      - Continue until all levels
        are processed.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Queue)
    */

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans =
                new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q =
                new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0;
                 i < size;
                 i++) {

                TreeNode node =
                        q.poll();

                if (i + 1 == size) {
                    ans.add(node.val);
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        BinaryTreeRightSideView obj =
                new BinaryTreeRightSideView();

        TreeNode root =
                new TreeNode(1);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(3);

        root.left.right =
                new TreeNode(5);

        root.right.right =
                new TreeNode(4);

        List<Integer> result =
                obj.rightSideView(root);

        System.out.println(
                "Right Side View : " + result);
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