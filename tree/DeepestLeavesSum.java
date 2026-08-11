package tree;

public class DeepestLeavesSum {

    /*
      Platform : LeetCode

      Question : Deepest Leaves Sum

      Pattern  : Tree Traversal (DFS)
                 + Height / Depth

      Approach :
      DFS with Depth Tracking

      Idea :
      - DFS se tree traverse karo.
      - Har node ke saath uski
        current depth maintain karo.
      - Jab leaf node mile:
          - Agar depth maxDepth se
            greater hai, maxDepth aur
            sum update karo.
          - Agar depth maxDepth ke
            equal hai, leaf value ko
            sum mein add karo.
      - Is tarah sirf deepest
        leaves ka sum milega.

      Time Complexity :
      O(n)

      Space Complexity :
      O(h)

      (Recursive Call Stack)
    */

    int maxDepth = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {

        solve(root, 0);

        return sum;
    }

    public void solve(TreeNode root,
                      int depth) {

        if (root == null) {
            return;
        }

        if (root.left == null
                && root.right == null) {

            if (depth > maxDepth) {

                maxDepth = depth;
                sum = root.val;

            } else if (depth == maxDepth) {

                sum += root.val;
            }

            return;
        }

        solve(root.left,
              depth + 1);

        solve(root.right,
              depth + 1);
    }

    public static void main(String[] args) {

        DeepestLeavesSum obj =
                new DeepestLeavesSum();

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

        root.right.right =
                new TreeNode(6);

        root.left.left.left =
                new TreeNode(7);

        root.right.right.right =
                new TreeNode(8);

        int result =
                obj.deepestLeavesSum(root);

        System.out.println(
                "Deepest Leaves Sum : " + result);
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