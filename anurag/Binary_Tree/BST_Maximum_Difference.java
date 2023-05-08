package com.anurag.Binary_Tree;

public class BST_Maximum_Difference {
    public static Node target_node;
    public static int find_target_sum(Node root, int target) {
        if(root == null) return -1;
        if(root.data == target) {
            target_node = root;
            return target;
        }

        int left = find_target_sum(root.left, target);
        int right = find_target_sum(root.right, target);

        if(left != -1) return left + root.data;
        if(right != -1) return left + root.data;
        return -1;
    }

    public static int get_min_sum(Node root) {
        if(root == null) return 0;
        int left = get_min_sum(root.left);
        int right = get_min_sum(root.right);
        if(left < right) {
            return left + root.data;
        }
        return right + root.data;
    }
    public static int maxDifferenceBST(Node root,int target) {

        //Please code here
        target_node = null;
        int target_to_root_sum = find_target_sum(root, target) - target;
        if(target_to_root_sum == -1) return -1;
        int min_sum = get_min_sum(target_node) - target;
        return target_to_root_sum - min_sum;
    }
    public static void main(String[] args) {

    }
}
