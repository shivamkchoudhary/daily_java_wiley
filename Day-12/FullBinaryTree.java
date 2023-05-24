package com.shivamkchoudhary;

public class FullBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
         root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
         root.right.left = new Node(60);
         root.right.right = new Node(70);

        System.out.println(isFullBinaryTree(root));
    }

    static boolean isFullBinaryTree(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right != null) {
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        } else {
            return false;
        }
    }
}
