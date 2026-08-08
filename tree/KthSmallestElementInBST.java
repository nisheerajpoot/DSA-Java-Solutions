package tree;

public class KthSmallestElementInBST {

    /*
      Platform : LeetCode

      Question : Kth Smallest Element in a BST

      Pattern  : Binary Search Tree (BST)

      Approach :
      Inorder Traversal

      Idea :
      - Inorder traversal of a BST
        gives values in sorted order.
      - Maintain a count of visited
        nodes.
      - When count becomes equal
        to k, return that node value.
      - First search the left subtree.
      - Then process the current node.
      - Finally search the right subtree.

      Time Complexity :
      O(h + k)

      Space Complexity :
      O(h)

      (Recursive Call Stack)
    */

    int count = 0;

    public int kthSmallest(TreeNode root,
                           int k) {

        return solve(root, k);
    }

    public int solve(TreeNode root,
                     int k) {

        if (root == null) {
            return -1;
        }

        int left =
                solve(root.left, k);

        if (left != -1) {
            return left;
        }

        count++;

        if (count == k) {
            return root.val;
        }

        return solve(root.right, k);
    }

    public static void main(String[] args) {

        KthSmallestElementInBST obj =
                new KthSmallestElementInBST();

        TreeNode root =
                new TreeNode(3);

        root.left =
                new TreeNode(1);

        root.right =
                new TreeNode(4);

        root.left.right =
                new TreeNode(2);

        int k = 1;

        int result =
                obj.kthSmallest(root, k);

        System.out.println(
                "Kth Smallest Element : " + result);
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