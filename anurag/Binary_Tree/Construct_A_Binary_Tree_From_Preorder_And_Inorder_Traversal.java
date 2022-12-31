package com.anurag.Binary_Tree;

public class Construct_A_Binary_Tree_From_Preorder_And_Inorder_Traversal {
    public static int getIndex(int[] inorder, int start, int end, int target){
        for(int i=start;i<=end;i++){
            if(inorder[i] == target) return i;
        }
        return -1;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, int pStart) {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int root_index = getIndex(inorder, start, end, preorder[pStart]);

        root.left = buildTree(preorder, inorder, start, root_index-1, pStart+1);
        root.right = buildTree(preorder, inorder, root_index+1, end, pStart+(root_index-start+1));
        return root;
    }
    public static void print(TreeNode root){
        if(root == null){
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder, 0, 4, 0);
        print(root);
    }
}
