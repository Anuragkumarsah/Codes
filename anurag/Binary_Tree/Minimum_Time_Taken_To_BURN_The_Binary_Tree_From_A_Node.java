package com.anurag.Binary_Tree;

import java.util.*;

public class Minimum_Time_Taken_To_BURN_The_Binary_Tree_From_A_Node {

    // This function returns the time required to burn the whole tree
    public static int time_needed_to_burn_tree(TreeNode target_node, Map<TreeNode, TreeNode> parent_map, HashSet<TreeNode> visited){
        // If the target node is null that means no time is required to burn the tree as there is no tree attached to the node
        if(target_node == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target_node);
        int count = 0;

        // Here we are going for the level order traversal as we just need to find how many nodes away is the last tree node, which can be
        // done easily using level order traversal, for this traversal we are using the batch level traversal, as they will burn at the same
        // time, so we are incrementing count after one whole batch is traversed
        while(!queue.isEmpty()){
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if(node.left!=null && !visited.contains(node.left)) queue.add(node.left);
                if(node.right!=null && !visited.contains(node.right)) queue.add(node.right);
                TreeNode parent = parent_map.get(node);
                if(parent!=null && !visited.contains(parent)) queue.add(parent);
                visited.add(node);
            }
            count = count+1;
        }
        // we are returning count - 1 as, we incremented 1 second time for the target node to burn while that is not the case
        return count-1;
    }

    // This function maps the nodes with their parent, like what is parent of the subtree root.
    public static void mark_parents(TreeNode root, Map<TreeNode, TreeNode> parent_map){
        if(root == null) return;
        // marking the left subtree root to it's parents
        if(root.left!=null) parent_map.put(root.left, root);
        // marking the right subtree root to it's parents
        if(root.right!=null) parent_map.put(root.right, root);
        mark_parents(root.left, parent_map);
        mark_parents(root.right, parent_map);
    }

    //This functions returns us the target node from the tree.
    private static TreeNode mark_node(TreeNode root, TreeNode target_node, int target) {
        if (root == null) return target_node;
        if(root.val == target)
            return root;

        target_node = mark_node(root.left, target_node, target);
        // if I did find the answer in the left part I simply return the node
        if(target_node!=null) return target_node;
        // else I check for it in the right part, and as I did not find it in the left part that means currently my target_node
        // value is null so, I just pass null in the place of target_node, I could also have passed target_node, and it would have given
        // me the same result.
        target_node = mark_node(root.right, null, target);
        return target_node;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Map<TreeNode, TreeNode> parent_map = new HashMap<>();
        mark_parents(root, parent_map);
        TreeNode target_node = mark_node(root, null, 5);
        System.out.println(time_needed_to_burn_tree(target_node, parent_map, new HashSet<>()));
    }
}
