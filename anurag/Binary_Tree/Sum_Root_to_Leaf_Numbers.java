package com.anurag.Binary_Tree;

public class Sum_Root_to_Leaf_Numbers {
    static int ans = 0;
    public static void sum(TreeNode root, int number){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans = ans + (number*10 + root.val);
            return;
        }

        number = (number*10) + root.val;
        sum(root.left, number);
        sum(root.right, number);
    }
    public static int sumNumbers(TreeNode root) {
        sum(root, 0);
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }
}
