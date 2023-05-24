package com.shivamkchoudhary;

public class CompleteBinaryTree {
    Node root;

    int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return (1 + countNodes(root.left) + countNodes(root.right));
    }

    boolean isComplete(Node root, int index, int count) {
        if (root == null) {
            return true;
        }

        if (index >= count) {
            return false;
        }

        return (isComplete(root.left, 2 * index + 1, count) && isComplete(root.right, 2 * index + 2, count));
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);

        int nodeCount = tree.countNodes(tree.root);
        int index = 0;

        if (tree.isComplete(tree.root, index, nodeCount)) {
            System.out.println("The tree is a complete binary tree");
        } else {
            System.out.println("The tree is not a complete binary tree");
        }
    }
}
