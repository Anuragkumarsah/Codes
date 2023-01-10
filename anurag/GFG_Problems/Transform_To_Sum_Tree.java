package com.anurag.GFG_Problems;

import com.anurag.DynamicProgramming.GFG.Node;

public class Transform_To_Sum_Tree {
    public int toSumTree(Node root){
        if(root == null) return 0;
        int left = toSumTree(root.left);
        int right = toSumTree(root.right);
        int root_val = root.data;
        root.data = left+right;
        return left+right+root_val;
    }
    public static void main(String[] args) {

    }
}
