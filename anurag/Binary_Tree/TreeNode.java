package com.anurag.Binary_Tree;

public class TreeNode {
        int val;
        com.anurag.Binary_Tree.TreeNode left;
        com.anurag.Binary_Tree.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, com.anurag.Binary_Tree.TreeNode left, com.anurag.Binary_Tree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}
