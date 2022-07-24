package com.anurag.Binary_Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Sprial_LevelOrder_Traversal {

    public List<Integer> findSpiral(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Node node = q.poll();
                if(!flag){
                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);
                }else{
                    if(node.right != null) q.offer(node.right);
                    if(node.left != null) q.offer(node.left);
                }
                ans.add(node.data);
            }
            flag = !flag;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
