package com.anurag.Binary_Tree;

import java.util.ArrayList;

public class Root_to_Node_path {
    public static boolean printRootToNode(TreeNode root, ArrayList<Integer> ans, int target){
        if(root == null){
            return false;
        }
        ans.add(root.val);
        if(root.val == target){
            return true;
        }
        if(printRootToNode(root.left, ans, target) || printRootToNode(root.right, ans, target)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        ArrayList<Integer> ans = new ArrayList<>();
        printRootToNode(root, ans, 7);
        System.out.println(ans);
    }
    // Time Complexity is O(N) where N is the total number of Nodes
    // Space Complexity is O(N) where N is the total number of Nodes in Tree,
    // this can only happen when we have skewed tree
}
