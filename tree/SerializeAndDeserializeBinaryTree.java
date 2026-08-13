package tree;

import java.util.ArrayList;

public class SerializeAndDeserializeBinaryTree {

    /*
      Platform : GeeksforGeeks

      Question : Serialize and Deserialize
                 a Binary Tree

      Pattern  : Tree Construction

      Approach :
      Preorder Traversal

      Idea :
      - Serialize the tree using
        preorder traversal.
      - Store -1 for every null node.
      - For deserialization, use
        the same preorder sequence.
      - If the current value is -1,
        return null.
      - Otherwise, create a node
        and recursively construct
        its left and right subtree.

      Time Complexity :
      O(n)

      Space Complexity :
      O(n)

      (ArrayList + Recursive
       Call Stack)
    */

    int index = 0;

    public ArrayList<Integer> serialize(Node root) {

        ArrayList<Integer> arr =
                new ArrayList<>();

        serializeHelper(root,
                        arr);

        return arr;
    }

    public void serializeHelper(Node root,
                                ArrayList<Integer> arr) {

        if (root == null) {

            arr.add(-1);

            return;
        }

        arr.add(root.data);

        serializeHelper(root.left,
                        arr);

        serializeHelper(root.right,
                        arr);
    }

    public Node deSerialize(ArrayList<Integer> arr) {

        index = 0;

        return solve(arr);
    }

    public Node solve(ArrayList<Integer> arr) {

        if (arr.get(index) == -1) {

            index++;

            return null;
        }

        Node root =
                new Node(arr.get(index));

        index++;

        root.left =
                solve(arr);

        root.right =
                solve(arr);

        return root;
    }

    public static void main(String[] args) {

        SerializeAndDeserializeBinaryTree obj =
                new SerializeAndDeserializeBinaryTree();

        Node root =
                new Node(1);

        root.left =
                new Node(2);

        root.right =
                new Node(3);

        root.right.left =
                new Node(4);

        root.right.right =
                new Node(5);

        ArrayList<Integer> serialized =
                obj.serialize(root);

        System.out.println(
                "Serialized Tree : "
                        + serialized);

        Node deserializedRoot =
                obj.deSerialize(serialized);

        System.out.println(
                "Deserialized Root : "
                        + deserializedRoot.data);
    }
}

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {

        this.data = data;

        left = right = null;
    }
}