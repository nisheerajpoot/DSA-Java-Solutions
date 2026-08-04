package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    /*
      Platform : LeetCode

      Question : Path Sum II

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Backtracking

      Idea :
      - Traverse the tree using
        DFS.
      - Maintain the current path
        and path sum.
      - Add the current node to
        the path.
      - If a leaf node is reached
        and the path sum equals
        the target sum, store the
        current path.
      - Recursively explore the
        left and right subtrees.
      - Backtrack by removing the
        current node from the path.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack +
       Current Path)
    */

    public List<List<Integer>> pathSum(TreeNode root,
                                       int targetSum) {

        List<List<Integer>> ans =
                new ArrayList<>();

        List<Integer> path =
                new ArrayList<>();

        check(root,
              targetSum,
              0,
              ans,
              path);

        return ans;
    }

    public void check(TreeNode root,
                      int targetSum,
                      int currSum,
                      List<List<Integer>> ans,
                      List<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        currSum = currSum + root.val;

        if (root.left == null
                && root.right == null) {

            if (currSum == targetSum) {
                ans.add(new ArrayList<>(path));
            }

        } else {

            check(root.left,
                  targetSum,
                  currSum,
                  ans,
                  path);

            check(root.right,
                  targetSum,
                  currSum,
                  ans,
                  path);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        PathSumII obj =
                new PathSumII();

        TreeNode root =
                new TreeNode(5);

        root.left =
                new TreeNode(4);

        root.right =
                new TreeNode(8);

        root.left.left =
                new TreeNode(11);

        root.left.left.left =
                new TreeNode(7);

        root.left.left.right =
                new TreeNode(2);

        root.right.left =
                new TreeNode(13);

        root.right.right =
                new TreeNode(4);

        root.right.right.left =
                new TreeNode(5);

        root.right.right.right =
                new TreeNode(1);

        int targetSum = 22;

        List<List<Integer>> result =
                obj.pathSum(root,
                            targetSum);

        System.out.println(
                "Path Sum II : " + result);
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