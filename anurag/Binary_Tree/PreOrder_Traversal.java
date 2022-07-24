package com.anurag.Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return ans;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            ans.add(temp.val);
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
        }
        return ans;
    }
    public List<Integer> preorderTraversal_recursion(TreeNode root, List<Integer> ans) {
        if(root == null) return ans;
        ans.add(root.val);
        preorderTraversal_recursion(root.left, ans);
        preorderTraversal_recursion(root.right, ans);
        return ans;
    }
    public static void main(String[] args) {

    }
}
