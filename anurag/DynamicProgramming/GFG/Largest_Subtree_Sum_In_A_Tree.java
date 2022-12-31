package com.anurag.DynamicProgramming.GFG;


public class Largest_Subtree_Sum_In_A_Tree {
    public static int findLargestSubtreeSum(Node root, int[] max) {
        if(root == null) return 0;
        int left = findLargestSubtreeSum(root.left, max);
        int right = findLargestSubtreeSum(root.right, max);
        int sum = root.data + right + left;
        max[0] = Math.max(max[0], sum);
        return sum;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(-4);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(6);
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findLargestSubtreeSum(root, max);
//        findLargestSubtreeSum(root);
    }
}
