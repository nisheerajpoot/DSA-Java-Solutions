package tree;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {

    /*
      Platform : LeetCode

      Question : Find Mode in Binary Search Tree

      Pattern  : Binary Search Tree (BST)

      Approach :
      Inorder Traversal

      Idea :
      - Inorder traversal of a BST
        gives values in sorted order.
      - Track the previous value
        using prev.
      - Track the frequency of the
        current value using currCount.
      - If the current value is the
        same as the previous value,
        increase the count.
      - Otherwise, reset the count
        for the new value.
      - If currCount is greater
        than maxCount, clear the
        answer and add the current
        value.
      - If currCount equals
        maxCount, add the current
        value to the answer.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Answer List + Recursive
       Call Stack)
    */

    List<Integer> ans =
            new ArrayList<>();

    int prev = 0;
    int currCount = 0;
    int maxCount = 0;
    boolean first = true;

    public int[] findMode(TreeNode root) {

        inorder(root);

        int[] result =
                new int[ans.size()];

        for (int i = 0;
             i < ans.size();
             i++) {

            result[i] = ans.get(i);
        }

        return result;
    }

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (first) {

            prev = root.val;
            currCount = 1;
            first = false;

        } else if (root.val == prev) {

            currCount++;

        } else {

            currCount = 1;
            prev = root.val;
        }

        // Update Answer
        if (currCount > maxCount) {

            maxCount = currCount;

            ans.clear();

            ans.add(root.val);

        } else if (currCount == maxCount) {

            ans.add(root.val);
        }

        // Right
        inorder(root.right);
    }

    public static void main(String[] args) {

        FindModeInBinarySearchTree obj =
                new FindModeInBinarySearchTree();

        TreeNode root =
                new TreeNode(2);

        root.left =
                new TreeNode(1);

        root.right =
                new TreeNode(2);

        int[] result =
                obj.findMode(root);

        System.out.print(
                "Modes : ");

        for (int value : result) {
            System.out.print(value + " ");
        }
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