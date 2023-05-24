package com.shivamkchoudhary;

class Node {
    int item;
    Node left, right;

    public Node(int key) {
        item = key;
        left = right = null;
    }
}
public class BinaryTree {
    Node root;
    public BinaryTree() {
        root = null;
    }
    void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.item + "----> ");
    }
    void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.item + "----> ");
        printInorder(node.right);
    }
    void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.item + "----> ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(11);
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
    }
}
