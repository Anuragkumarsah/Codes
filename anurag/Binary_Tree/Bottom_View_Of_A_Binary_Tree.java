package com.anurag.Binary_Tree;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair3{
    TreeNode node;
    int line;
    public Pair3(int line, TreeNode node){
        this.line = line;
        this.node = node;
    }
}

// The logic we followed here is ...... we consider root node as position 0 or vertical 0
// and every time we move left we decrement the vertical value by 1 and while moving right
// we increment by 1 by this we can get at what vertical position is the node present, then
// if not covered we add it to the map otherwise we replace it with the new value

public class Bottom_View_Of_A_Binary_Tree {
    public static Map<Integer, Integer> levelOrderTraversal(TreeNode root){

        // We are using TreeMap so that the map can be iterated in ascending order

        Map<Integer, Integer> ans = new TreeMap<>();
        if(root == null) return ans;
        Queue<Pair3> q = new LinkedList<>();
        q.offer(new Pair3(0, root));
        while(!q.isEmpty()){
            int level = q.size();
            for(int i=0;i<level;i++){
                Pair3 pair = q.poll();
                assert pair!=null;
                // checking whether we have covered a line (vertical) or not, if not covered we add it to the map otherwise we replace it with the new value
                if(ans.containsKey(pair.line)) ans.replace(pair.line, pair.node.val);
                else ans.put(pair.line, pair.node.val);

                //Level Order Traversal
                if(pair.node.left != null) q.offer(new Pair3(pair.line-1, pair.node.left));
                if(pair.node.right != null) q.offer(new Pair3(pair.line+1, pair.node.right));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        Map<Integer, Integer> ans = levelOrderTraversal(root);
        for (Map.Entry<Integer,Integer> entry : ans.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
