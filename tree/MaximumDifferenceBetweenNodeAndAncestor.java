package tree;

public class MaximumDifferenceBetweenNodeAndAncestor {

    /*
      Platform : GeeksForGeeks

      Question : Maximum Difference Between Node and its Ancestor

      Pattern  : Tree Traversal (DFS)

      Approach :
      Recursive Minimum Value Tracking

      Idea :
      - Traverse the tree using DFS.
      - Find the minimum value present
        in the subtree.
      - For every node, calculate
        the difference between the
        current node value and the
        minimum value in its child
        subtrees.
      - Update the maximum difference.
      - Return the minimum value
        of the current subtree.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (Recursive Call Stack)
    */

    int max = Integer.MIN_VALUE;

    int maxDiff(Node root) {

        solve(root);

        return max;
    }

    public int solve(Node root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin =
                solve(root.left);

        int rightMin =
                solve(root.right);

        int minimum =
                Math.min(root.data,
                        Math.min(leftMin, rightMin));

        if (leftMin != Integer.MAX_VALUE) {

            max = Math.max(max,
                    root.data - leftMin);
        }

        if (rightMin != Integer.MAX_VALUE) {

            max = Math.max(max,
                    root.data - rightMin);
        }

        return minimum;
    }

    public static void main(String[] args) {

        MaximumDifferenceBetweenNodeAndAncestor obj =
                new MaximumDifferenceBetweenNodeAndAncestor();

        Node root =
                new Node(8);

        root.left =
                new Node(3);

        root.right =
                new Node(10);

        root.left.left =
                new Node(1);

        root.left.right =
                new Node(6);

        root.right.right =
                new Node(14);

        int result =
                obj.maxDiff(root);

        System.out.println(
                "Maximum Difference : " + result);
    }
}

class Node {

    int data;
    Node left;
    Node right;

    Node(int item) {

        data = item;
        left = right = null;
    }
}