package com.anurag.Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder_Traversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }
            else {
                if(stack.isEmpty())
                    break;
                node = stack.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }

    public List<Integer> inorderTraversal_Recursion(TreeNode root, List<Integer> ans){
        if(root == null){
            return ans;
        }
        inorderTraversal_Recursion(root.left, ans);
        ans.add(root.val);
        inorderTraversal_Recursion(root.right, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
