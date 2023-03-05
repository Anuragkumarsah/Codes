package com.anurag.Binary_Tree;

import java.util.*;



class Pair2{
    TreeNode node;
    int line;
    public Pair2(int line, TreeNode node){
        this.node = node;
        this.line = line;
    }
}

// The logic we followed here is ...... we consider root node as position 0 or vertical 0
// and every time we move left we decrement the vertical value by 1 and while moving right
// we increment by 1 by this we can get at what vertical position is the node present, then we
// add it to our answer if we have not visited any node on that vertical.


public class Top_view_of_Binary_Tree {
    public static Map<Integer, Integer> levelOrderTraversal(TreeNode root){

        // We are using TreeMap so that the map can be iterated in ascending order

        Map<Integer, Integer> ans = new TreeMap<>();
        if(root == null) return ans;
        Queue<Pair2> q = new LinkedList<>();
        q.offer(new Pair2(0, root));
        while(!q.isEmpty()){
                Pair2 pair = q.poll();
                assert pair!=null;
                // checking whether we have covered a line (vertical) or not, if not covered we add it to the map
                if(!ans.containsKey(pair.line)) ans.put(pair.line, pair.node.val);

                //Level Order Traversal
                if(pair.node.left != null) q.offer(new Pair2(pair.line-1, pair.node.left));
                if(pair.node.right != null) q.offer(new Pair2(pair.line+1, pair.node.right));
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Map<Integer, Integer> ans = levelOrderTraversal(root);
        for (Map.Entry<Integer,Integer> entry : ans.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
