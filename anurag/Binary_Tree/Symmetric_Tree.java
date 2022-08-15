package com.anurag.Binary_Tree;

public class Symmetric_Tree {
    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null || right == null) return left == right;
        if(left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(root == null || isSymmetric(root.left, root.right));
    }

    // Time Complexity is O(N) where N is the total Number of Nodes
    // Space complexity is O(N) where N is the stack space used by Recursion
}
