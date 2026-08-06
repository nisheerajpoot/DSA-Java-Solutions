package tree;

public class SumRootToLeafNumbers {

    /*
      Platform : LeetCode

      Question : Sum Root to Leaf Numbers

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Path Number Formation

      Idea :
      - Traverse the tree using
        DFS.
      - Form the current number by
        multiplying the previous
        number by 10 and adding the
        current node value.
      - When a leaf node is reached,
        add the current number to
        the final answer.
      - Continue recursively for
        the left and right
        subtrees.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    int ans = 0;

    public int sumNumbers(TreeNode root) {

        int currNum = 0;

        solve(root,
              currNum);

        return ans;
    }

    public void solve(TreeNode root,
                      int currNum) {

        if (root == null) {
            return;
        }

        currNum =
                currNum * 10 + root.val;

        if (root.left == null
                && root.right == null) {

            ans += currNum;
        }

        solve(root.left,
              currNum);

        solve(root.right,
              currNum);
    }

    public static void main(String[] args) {

        SumRootToLeafNumbers obj =
                new SumRootToLeafNumbers();

        TreeNode root =
                new TreeNode(4);

        root.left =
                new TreeNode(9);

        root.right =
                new TreeNode(0);

        root.left.left =
                new TreeNode(5);

        root.left.right =
                new TreeNode(1);

        int result =
                obj.sumNumbers(root);

        System.out.println(
                "Sum Root To Leaf Numbers : " + result);
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