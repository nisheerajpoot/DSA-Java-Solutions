package tree;

public class ConstructBinaryTreeFromInorderAndPostorder {

    /*
      Platform : LeetCode

      Question : Construct Binary Tree
                 from Inorder and Postorder Traversal

      Pattern  : Tree Construction

      Approach :
      Recursion

      Idea :
      - Postorder ka last element
        current root hota hai.
      - Inorder mein root ka index
        find karte hain.
      - Root ke right side ke elements
        right subtree banate hain.
      - Root ke left side ke elements
        left subtree banate hain.
      - postIndex ko decrement karke
        next root select karte hain.

      Time Complexity :
      O(n²)

      Space Complexity :
      O(n)

      (Recursive Call Stack +
       Tree Nodes)
    */

    int postIndex;

    public TreeNode buildTree(int[] inorder,
                              int[] postorder) {

        postIndex =
                postorder.length - 1;

        return solve(inorder,
                     postorder,
                     0,
                     inorder.length - 1);
    }

    public TreeNode solve(int[] inorder,
                          int[] postorder,
                          int start,
                          int end) {

        if (start > end) {
            return null;
        }

        TreeNode root =
                new TreeNode(postorder[postIndex]);

        postIndex--;

        int index = 0;

        for (int i = start;
             i <= end;
             i++) {

            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        root.right =
                solve(inorder,
                      postorder,
                      index + 1,
                      end);

        root.left =
                solve(inorder,
                      postorder,
                      start,
                      index - 1);

        return root;
    }

    public static void main(String[] args) {

        ConstructBinaryTreeFromInorderAndPostorder obj =
                new ConstructBinaryTreeFromInorderAndPostorder();

        int[] inorder = {
                9, 3, 15, 20, 7
        };

        int[] postorder = {
                9, 15, 7, 20, 3
        };

        TreeNode root =
                obj.buildTree(inorder,
                              postorder);

        System.out.println(
                "Root : " + root.val);
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