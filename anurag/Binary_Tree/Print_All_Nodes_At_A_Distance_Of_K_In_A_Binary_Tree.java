package com.anurag.Binary_Tree;

import java.util.*;

public class Print_All_Nodes_At_A_Distance_Of_K_In_A_Binary_Tree {

    // This function checks for the distance travelled and which nodes are k distance apart from the target node
    public static void find_Nodes(TreeNode root, int count, int k, Map<TreeNode, TreeNode> parent_map, HashSet<TreeNode> visited, ArrayList<Integer> ans){
        if(root == null) return;

        //Checking if we have visited the node earlier or not, if we have visited that means that we don't need to check for it again
        //as if it has not given an answer earlier it will never give us the answer.

        if(visited.contains(root)) return;
        else
            visited.add(root);

        // checking whether if the distance we wanted to visit is covered or not, if covered then we add it to our answer

        if(count == k){
            ans.add(root.val);
            return;
        }

        // checking the left subtree

        find_Nodes(root.left, count+1, k, parent_map, visited, ans);

        //checking the right subtree

        find_Nodes(root.right, count+1, k, parent_map, visited, ans);

        // Checking the parent (above as the answer can be in some other subtree)
        find_Nodes(parent_map.get(root), count+1, k, parent_map, visited, ans);
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

    // This parent returns the node which we need to start (The target node)
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        Map<TreeNode, TreeNode> parent_map = new HashMap<>();
        mark_parents(root, parent_map);
        TreeNode target_node = mark_node(root,null,  4);
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        find_Nodes(target_node, 0, 2, parent_map, visited, ans);
        System.out.println(ans);
    }
}
