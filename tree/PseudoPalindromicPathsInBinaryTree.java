package tree;

public class PseudoPalindromicPathsInBinaryTree {

    /*
      Platform : LeetCode

      Question : Pseudo-Palindromic Paths
                 in a Binary Tree

      Pattern  : Tree Traversal (DFS)

      Approach :
      Backtracking with Frequency Array

      Idea :
      - Traverse the tree using
        DFS.
      - Maintain the frequency of
        each digit (1-9) along the
        current root-to-leaf path.
      - At every leaf node, count
        how many digits have an
        odd frequency.
      - If at most one digit has
        an odd frequency, the path
        is pseudo-palindromic.
      - Backtrack by decreasing the
        frequency before returning.

      Time Complexity :
      O(n)

      Space Complexity :
      O(h)

      (Recursive Call Stack)
    */

    int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {

        int[] freq =
                new int[10];

        solve(root,
              freq);

        return ans;
    }

    public void solve(TreeNode root,
                      int[] freq) {

        if (root == null) {
            return;
        }

        freq[root.val]++;

        if (root.left == null
                && root.right == null) {

            int oddfreq = 0;

            for (int i = 0;
                 i <= 9;
                 i++) {

                if (freq[i] % 2 != 0) {
                    oddfreq++;
                }
            }

            if (oddfreq == 0
                    || oddfreq == 1) {

                ans++;
            }
        }

        solve(root.left,
              freq);

        solve(root.right,
              freq);

        freq[root.val]--;
    }

    public static void main(String[] args) {

        PseudoPalindromicPathsInBinaryTree obj =
                new PseudoPalindromicPathsInBinaryTree();

        TreeNode root =
                new TreeNode(2);

        root.left =
                new TreeNode(3);

        root.right =
                new TreeNode(1);

        root.left.left =
                new TreeNode(3);

        root.left.right =
                new TreeNode(1);

        root.right.right =
                new TreeNode(1);

        int result =
                obj.pseudoPalindromicPaths(root);

        System.out.println(
                "Pseudo Palindromic Paths : " + result);
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