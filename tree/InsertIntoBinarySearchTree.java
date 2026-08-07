package tree;

public class InsertIntoBinarySearchTree {

    /*
      Platform : LeetCode

      Question : Insert into a Binary Search Tree

      Pattern  : Binary Search Tree (BST)

      Approach :
      Recursive BST Insertion

      Idea :
      - If the current node is
        null, create a new node
        and return it.
      - If the value is smaller
        than the current node,
        insert it into the left
        subtree.
      - Otherwise, insert it into
        the right subtree.
      - Return the current node
        after insertion.

      Time Complexity :
      O(h)

      Space Complexity :
      O(h)

      (Recursive Call Stack)

      h = Height of the Tree
    */

    public TreeNode insertIntoBST(TreeNode root,
                                  int val) {

        if (root == null) {

            TreeNode newNode =
                    new TreeNode(val);

            return newNode;
        }

        if (val < root.val) {

            root.left =
                    insertIntoBST(root.left,
                                  val);

        } else {

            root.right =
                    insertIntoBST(root.right,
                                  val);
        }

        return root;
    }

    public static void main(String[] args) {

        InsertIntoBinarySearchTree obj =
                new InsertIntoBinarySearchTree();

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

        int value = 5;

        root = obj.insertIntoBST(root,
                                 value);

        System.out.println(
                "Root : " + root.val);

        System.out.println(
                "Inserted Node : " + root.right.left.val);
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