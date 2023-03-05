package com.anurag.Binary_Tree;

public class Fixing_Two_Swapped_Nodes_Of_A_BST {
    public static Node first = null, pair = null, second = null, prev = null;
    public static Node findBST(Node root) {
        if(root == null) return null;
        findBST(root.left);
        if(prev!=null && root.data < prev.data){
            if(first == null) {
                first = prev;
                pair = root;
            } else {
                second = prev;
            }
        }
        prev = root;
        findBST(root.right);
        return root;
    }
    public static void main(String[] args) {

    }
}
