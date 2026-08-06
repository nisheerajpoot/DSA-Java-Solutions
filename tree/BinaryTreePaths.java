package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    /*
      Platform : LeetCode

      Question : Binary Tree Paths

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Backtracking

      Idea :
      - Traverse the tree using
        DFS.
      - Maintain the current path
        using StringBuilder.
      - Store the current length
        before adding the node.
      - If a leaf node is reached,
        add the path to the answer.
      - Otherwise, append "->"
        and explore the left and
        right subtrees.
      - Backtrack by restoring the
        previous StringBuilder
        length.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack +
       Path String)
    */

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans =
                new ArrayList<>();

        StringBuilder path =
                new StringBuilder();

        solve(root,
              ans,
              path);

        return ans;
    }

    public void solve(TreeNode root,
                      List<String> ans,
                      StringBuilder path) {

        if (root == null) {
            return;
        }

        int len =
                path.length();

        path.append(root.val);

        if (root.left == null
                && root.right == null) {

            ans.add(path.toString());

        } else {

            path.append("->");

            solve(root.left,
                  ans,
                  path);

            solve(root.right,
                  ans,
                  path);
        }

        path.setLength(len);
    }

    public static void main(String[] args) {

        BinaryTreePaths obj =
                new BinaryTreePaths();

        TreeNode root =
                new TreeNode(1);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(3);

        root.left.right =
                new TreeNode(5);

        List<String> result =
                obj.binaryTreePaths(root);

        System.out.println(
                "Binary Tree Paths : " + result);
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