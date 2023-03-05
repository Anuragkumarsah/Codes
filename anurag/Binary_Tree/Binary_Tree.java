package com.anurag.Binary_Tree;

public class Binary_Tree {
    public static void main(String[] args) {
        BTree root = new BTree(10);
        System.out.println(root);
        BTree.addRight(root, 8);
        BTree.addLeft(root, 5);

        BTree.addRight(root.right, 9);
        BTree.addLeft(root.right, 3);

        BTree.print(root);
    }
}
