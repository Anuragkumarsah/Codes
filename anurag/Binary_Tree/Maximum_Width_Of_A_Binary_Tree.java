package com.anurag.Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;


// Q-> Given the root of a binary tree, return the maximum width of the given tree.
//
//      The maximum width of a tree is the maximum width among all levels.
//
//      The width of one level is defined as the length between the end-nodes
//      (the leftmost and rightmost non-null nodes), where the null nodes between
//      the end-nodes that would be present in a complete binary tree extending down
//      to that level are also counted into the length calculation.



class Index_Pair{
    TreeNode root;
    int index;
    Index_Pair(TreeNode root, int index){
        this.root = root;
        this.index = index;
    }
}

public class Maximum_Width_Of_A_Binary_Tree {
    public static int LevelOrder(TreeNode root){
        if(root == null) return 0;

        // We are doing the simple Level Order Traversal, but we are marking the index of the particular node
        // so that we can know at what width we are in the tree i.e. what is the leftmost and the rightmost
        // index of the tree of a level.

        Queue<Index_Pair> q = new LinkedList<>();
        q.offer(new Index_Pair(root, 0));
        int idx = 0, first = 0, last = 0, max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Index_Pair node = q.poll();
                if(i==0){
                   idx = node.index;
                   first = idx;
                }
                if (i == level-1){
                    assert node != null;
                    last = node.index;
                }
                assert node!=null;

                // here we could also have done something like 2*index+1 so that we can know whats the
                // current nodes index is or how many nodes we have traversed to get there, but after
                // some point we will get Integer overflow error as that number can go high that can
                // overflow int....so we are always starting a level's indexing from 0. To do so we need
                // the level's first node's index. We simply do 2 * index - min  for the left node and +1
                // for the right one

                if(node.root.left!=null) q.add(new Index_Pair(node.root.left, 2*(node.index-idx)));
                if(node.root.right!=null) q.add(new Index_Pair(node.root.right, 2*(node.index-idx)+1));
            }

            // At last we are calculating the first and the last node's index difference and checking whether it
            // is bigger than the earlier level's max width.

            max = Math.max(max, (last - first + 1));
        }

        return max;
    }
    public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(3);
            root.right = new TreeNode(7);
            root.left.left = new TreeNode(8);
            root.right.right = new TreeNode(4);
            root.left.left.left = new TreeNode(9);
            root.right.right.left = new TreeNode(10);
        System.out.println(LevelOrder(root));
    }
}
