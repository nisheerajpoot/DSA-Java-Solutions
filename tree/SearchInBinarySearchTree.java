package tree;

public class SearchInBinarySearchTree {

    /*
      Platform : LeetCode

      Question : Search in a Binary Search Tree

      Pattern  : Binary Search Tree (BST)

      Approach :
      Recursive BST Search

      Idea :
      - If the current node is
        null, the value does not
        exist.
      - If the current node value
        matches the target, return
        the current node.
      - If the target is smaller,
        search in the left subtree.
      - Otherwise, search in the
        right subtree.

      Time Complexity :
      O(h)

      Space Complexity :
      O(h)

      (Recursive Call Stack)

      h = Height of the Tree
    */

    public TreeNode searchBST(TreeNode root,
                              int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left,
                             val);
        } else {
            return searchBST(root.right,
                             val);
        }
    }

    public static void main(String[] args) {

        SearchInBinarySearchTree obj =
                new SearchInBinarySearchTree();

        TreeNode root =
                new TreeNode(4);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(7);

        root.left.left =
                new TreeNode(1);

        root.left.right =
                new TreeNode(3);

        int target = 2;

        TreeNode result =
                obj.searchBST(root,
                              target);

        if (result != null) {

            System.out.println(
                    "Node Found : " + result.val);

        } else {

            System.out.println(
                    "Node Not Found");
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