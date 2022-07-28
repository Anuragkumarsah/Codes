package com.anurag.Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level_Order_Traversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
       if(root == null) return ans;
       q.add(root);
       while(!q.isEmpty()){
           int levelNum = q.size();
           List<Integer> sublist = new LinkedList<>();

           for (int i = 0; i < levelNum; i++) {
               assert q.peek()!=null;
               if(q.peek().left!=null) q.add(q.peek().left);
               if (q.peek().right!=null) q.add(q.peek().right);
               sublist.add(q.poll().val);
           }
           ans.add(sublist);
       }
       return ans;
    }
    public static void main(String[] args) {

    }

}
