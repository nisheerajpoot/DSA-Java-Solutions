package tree;

public class ConstructBinaryTreeFromPreorderAndInorder {

    /*
      Platform : LeetCode

      Question : Construct Binary Tree
                 from Preorder and Inorder Traversal

      Pattern  : Tree Construction

      Approach :
      Recursion

      Idea :
      - Preorder ka first element
        current root hota hai.
      - Inorder mein root ka index
        find karte hain.
      - Root ke left side ke elements
        left subtree banate hain.
      - Root ke right side ke elements
        right subtree banate hain.
      - preIndex ko increment karke
        next root select karte hain.

      Time Complexity :
      O(n²)

      Space Complexity :
      O(n)

      (Recursive Call Stack +
       Tree Nodes)
    */

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder,
                              int[] inorder) {

        return solve(preorder,
                     inorder,
                     0,
                     inorder.length - 1);
    }

    public TreeNode solve(int[] preorder,
                          int[] inorder,
                          int start,
                          int end) {

        if (start > end) {
            return null;
        }

        TreeNode root =
                new TreeNode(preorder[preIndex]);

        preIndex++;

        int index = start;

        for (int i = start;
             i <= end;
             i++) {

            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        root.left =
                solve(preorder,
                      inorder,
                      start,
                      index - 1);

        root.right =
                solve(preorder,
                      inorder,
                      index + 1,
                      end);

        return root;
    }

    public static void main(String[] args) {

        ConstructBinaryTreeFromPreorderAndInorder obj =
                new ConstructBinaryTreeFromPreorderAndInorder();

        int[] preorder = {
                3, 9, 20, 15, 7
        };

        int[] inorder = {
                9, 3, 15, 20, 7
        };

        TreeNode root =
                obj.buildTree(preorder,
                              inorder);

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