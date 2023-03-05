package com.anurag.Binary_Tree;

public class BTree {
        int data;
        BTree left;
        BTree right;
        public BTree(int key){
            data = key;
        }
    public static void print(BTree root){
        if(root == null)
            return;
        print(root.left);
        print(root.right);
        System.out.println(root.data);
    }
    public static void addLeft(BTree root, int val){
        BTree temp = root;
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = new BTree(val);
    }
    public static void addRight(BTree root, int val){
        BTree temp = root;
        while(temp.right!=null){
            temp = temp.right;
        }
        temp.right = new BTree(val);
    }

    public static void main(String[] args) {
    }
}
