package com.anurag.Binary_Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                if(!flag){
                    subList.add(node.val);
                } else{
                    subList.add(0, node.val);
                }
            }
            ans.add(subList);
            flag = !flag;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
