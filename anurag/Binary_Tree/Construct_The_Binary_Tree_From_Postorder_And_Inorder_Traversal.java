package com.anurag.Binary_Tree;

public class Construct_The_Binary_Tree_From_Postorder_And_Inorder_Traversal {
    private static int getRoot_pos(int[] inOder, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (inOder[i] == target)    return i;
        }
        return -1;
    }
    public static TreeNode Construct_Tree(int[] inOder, int[] postOrder, int start, int end, int pStart){
        if(start > end){
            return null;
        }
//        System.out.println(postOrder[pStart]);
        TreeNode root = new TreeNode(postOrder[pStart]);
        int  root_pos = getRoot_pos(inOder, start, end, postOrder[pStart]);

        root.left = Construct_Tree(inOder, postOrder, start, root_pos - 1, pStart + root_pos - end-1);
        root.right = Construct_Tree(inOder, postOrder, root_pos + 1, end, pStart - 1);

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
        int[] postOrder = {40, 50, 20, 60, 30, 10};
        int[] inOrder = {40, 20, 50, 10, 60, 30};
        TreeNode root = Construct_Tree(inOrder, postOrder, 0, 5, 5);
        print(root);
    }
}
