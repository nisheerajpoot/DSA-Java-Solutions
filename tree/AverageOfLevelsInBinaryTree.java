package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    /*
      Platform : LeetCode

      Question : Average of Levels in Binary Tree

      Pattern  : Tree Traversal (BFS)

      Approach :
      Level Order Traversal

      Idea :
      - Traverse the tree level
        by level using a queue.
      - Calculate the sum of all
        nodes at the current level.
      - Divide the sum by the
        number of nodes at that
        level to get the average.
      - Store the average in the
        result list.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Queue)
    */

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> ans =
                new ArrayList<>();

        Queue<TreeNode> q =
                new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            long sum = 0;

            int size = q.size();

            for (int i = 0;
                 i < size;
                 i++) {

                TreeNode node =
                        q.poll();

                sum += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            ans.add((double) sum / size);
        }

        return ans;
    }

    public static void main(String[] args) {

        AverageOfLevelsInBinaryTree obj =
                new AverageOfLevelsInBinaryTree();

        TreeNode root =
                new TreeNode(3);

        root.left =
                new TreeNode(9);

        root.right =
                new TreeNode(20);

        root.right.left =
                new TreeNode(15);

        root.right.right =
                new TreeNode(7);

        List<Double> result =
                obj.averageOfLevels(root);

        System.out.println(
                "Average Of Levels : " + result);
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