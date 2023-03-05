package com.anurag.Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class Boundary_Traversal {
    static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }
    void addLeftBoundary(TreeNode root, ArrayList<Integer> ans){
        TreeNode current = root.left;
        while(current != null) {
            if (!isLeaf(current)) ans.add(current.val);
            if (current.left != null) current = current.left;
            else current = current.right;
        }
    }
    void addRightBoundary(TreeNode root, ArrayList<Integer> ans){
        TreeNode current = root.right;
        Stack<Integer> stack = new Stack<>();
        while(current!=null){
            if(!isLeaf(current)) stack.push(current.val);
            if(current.right != null) current = current.right;
            else current = current.left;
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
    }
    void addLeaves(TreeNode root, ArrayList<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.val);
            return;
        }
        if(root.left != null) addLeaves(root.left, ans);
        if(root.right != null) addLeaves(root.right, ans);
    }
    public ArrayList < Integer > printBoundary(TreeNode node) {
        ArrayList < Integer > ans = new ArrayList <> ();
        if (!isLeaf(node)) ans.add(node.val);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }
    //The time complexity will be O(H) + O(H) + O(N) which is ≈ O(N)
    // The space complexity will be O(N) as we are using a stack for Right Boundary
}
