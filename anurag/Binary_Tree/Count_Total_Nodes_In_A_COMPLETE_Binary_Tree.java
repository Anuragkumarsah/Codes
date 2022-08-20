package com.anurag.Binary_Tree;

public class Count_Total_Nodes_In_A_COMPLETE_Binary_Tree {
    public static int calculate_height(TreeNode node, int count, boolean right){
        if(node == null) return count;
        if(!right)
            count = calculate_height(node.left, count+1, false);
        else count = calculate_height(node.right, count+1, true);
        return count;
    }
    public static int count_nodes(TreeNode root){
        if(root == null) return 0;
        int left_height = calculate_height(root.left, 0, false);
        int right_height = calculate_height(root.right, 0, true);
        if(right_height == left_height){
            return (int)(2*(Math.pow(2, left_height)-1))+1;
        }else{
            return 1+count_nodes(root.left)+count_nodes(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(count_nodes(root));
    }
}
