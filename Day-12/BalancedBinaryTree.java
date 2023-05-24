package com.shivamkchoudhary;


class Node1 {
    int data;
    Node1 left, right;

    Node1(int d) {
        data = d;
        left = right = null;
    }
}
public class BalancedBinaryTree {
    Node1 root;

    int height(Node1 node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    boolean isBalanced(Node1 node) {
        int lh;
        int rh;

        if (node == null)
            return true;

        lh = height(node.left);
        rh = height(node.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right))
            return true;

        return false;
    }

    public static void main(String args[]) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);
        tree.root.left.left.left = new Node1(8);

        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
