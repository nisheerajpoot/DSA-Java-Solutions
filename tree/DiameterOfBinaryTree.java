package tree;

public class DiameterOfBinaryTree {

    /*
      Platform : LeetCode

      Question : Diameter of Binary Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Height Calculation

      Idea :
      - Maintain a global variable
        to store the maximum diameter.
      - Calculate the height of
        the left subtree.
      - Calculate the height of
        the right subtree.
      - Diameter passing through
        the current node is:
        Left Height + Right Height.
      - Update the maximum diameter.
      - Return the height of the
        current node to the parent.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        hight(root);

        return diameter;
    }

    public int hight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight =
                hight(root.left);

        int rightHeight =
                hight(root.right);

        int currentDiameter =
                leftHeight + rightHeight;

        diameter =
                Math.max(diameter, currentDiameter);

        return 1 + Math.max(leftHeight,
                            rightHeight);
    }

    public static void main(String[] args) {

        DiameterOfBinaryTree obj =
                new DiameterOfBinaryTree();

        TreeNode root =
                new TreeNode(1);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(3);

        root.left.left =
                new TreeNode(4);

        root.left.right =
                new TreeNode(5);

        int result =
                obj.diameterOfBinaryTree(root);

        System.out.println(
                "Diameter Of Binary Tree : " + result);
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