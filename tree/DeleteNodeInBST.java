package tree;

public class DeleteNodeInBST {

    /*
      Platform : LeetCode

      Question : Delete Node in a BST

      Pattern  : Binary Search Tree (BST)

      Approach :
      Recursive BST Deletion

      Idea :
      - Search for the node using
        BST properties.
      - If key is smaller, search
        in the left subtree.
      - If key is greater, search
        in the right subtree.
      - When the node is found:
        1. No child  -> return null.
        2. Only right child ->
           return right child.
        3. Only left child ->
           return left child.
        4. Two children ->
           find the inorder successor
           from the right subtree.
      - Replace the current node
        value with the successor
        value.
      - Delete the successor node
        from the right subtree.

      Time Complexity :
      O(h)

      Space Complexity :
      O(h)

      (Recursive Call Stack)

      h = Height of the Tree
    */

    public TreeNode deleteNode(TreeNode root,
                               int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {

            root.left =
                    deleteNode(root.left,
                               key);

        } else if (key > root.val) {

            root.right =
                    deleteNode(root.right,
                               key);

        } else {

            if (root.left == null&& root.right == null) {

                return null;

            } else if (root.left == null) {

                return root.right;

            } else if (root.right == null) {

                return root.left;

            } else {

                TreeNode successor =
                        root.right;

                while (successor.left != null) {

                    successor =
                            successor.left;
                }

                root.val =
                        successor.val;

                root.right =deleteNode(root.right,successor.val);
            }
        }

        return root;
    }

    public static void main(String[] args) {

        DeleteNodeInBST obj =
                new DeleteNodeInBST();

        TreeNode root =
                new TreeNode(5);

        root.left =
                new TreeNode(3);

        root.right =
                new TreeNode(6);

        root.left.left =
                new TreeNode(2);

        root.left.right =
                new TreeNode(4);

        root.right.right =
                new TreeNode(7);

        int key = 3;

        root =
                obj.deleteNode(root,
                               key);

        System.out.println(
                "Root After Deletion : "+ root.val);
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