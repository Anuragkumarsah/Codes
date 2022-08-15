package com.anurag.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {
    public static void pathSum(TreeNode root,int sum, int targetSum, List<Integer> list, List<List<Integer>> ans) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(sum+root.val == targetSum){
                list.add(root.val);
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        pathSum(root.left, sum+root.val, targetSum, list, ans);
        pathSum(root.right, sum+root.val, targetSum, list, ans);
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root,0, 22, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}
