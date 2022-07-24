package com.anurag.Binary_Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder_Traversal {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, node1 = root;
        while(true){
            if(node!=null){
                stack.push(node);
                node1 = node;
                node = node.left;
            }else if(node1.right!=null){
                node1 = null;
                TreeNode temp = stack.peek();
                node = temp.right;
            }else{
                if(stack.isEmpty())
                    break;
                TreeNode temp1 = stack.pop();
                node1 = stack.peek();
                ans.add(temp1.val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left = new TreeNode(1);
        System.out.println(postorderTraversal(root));
    }
}
