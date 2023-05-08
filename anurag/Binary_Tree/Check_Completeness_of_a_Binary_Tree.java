package com.anurag.Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Check_Completeness_of_a_Binary_Tree {
    public static boolean isCompleteTree(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int level = 0;
//        while(!queue.isEmpty()) {
//            int nodes = queue.size();
//            int queue_size = queue.size();
//
//            for(int i=0;i<nodes;i++) {
//                TreeNode node = queue.poll();
//                assert node != null;
//                if(node.left != null){
//                    queue.offer(node.left);
//                    if(node.right != null) queue.offer(node.right);
//                }
//            }
//            if(!queue.isEmpty() && queue_size != (1 << level)) {
//                return false;
//            }
//
//            level++;
//        }
//        return true;
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) end = true;
            else{
                if(end) return false;
                queue.add(cur.left);
                queue.add(cur.right);
            }
            System.out.println(queue.size());
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isCompleteTree(root));
    }
}
