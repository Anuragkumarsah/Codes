package com.anurag.Binary_Tree;

public class Children_Sum_In_Binary_Tree {
    public static void print(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val+" ");
        print(root.left);
        print(root.right);
    }
    public static int childrenSum(TreeNode root){
        if (root == null) return 0;
        if(root.left!=null){
            root.left.val = root.val;
        }
        if(root.right!=null){
            root.right.val = root.val;
        }
        int left = childrenSum(root.left);
        left = left== 0 ? root.val:left;
        int right = childrenSum(root.right);
        right = right == 0 ? root.val:right;
        root.val = left+right;
        return root.val;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(80);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);
        childrenSum(root);
        print(root);
    }
}
