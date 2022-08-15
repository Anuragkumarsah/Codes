package com.anurag.Binary_Tree;

public class Lowest_Common_Ancestor {
    public static Integer lowestCommonAncestor(int first, int second, TreeNode root){

        if(root == null)
            return null;

        if(root.val == first || root.val == second)
            return root.val;
        Integer left = lowestCommonAncestor(first, second, root.left);
        Integer right = lowestCommonAncestor(first, second, root.right);
        // This thing ensures that we get only the first node (Ancestor) from the bottom every time
        // as left and right can't be both not null for any other ancestor, except the first.
        if(left == null){
            return right;
        }else if (right == null)
            return left;
        else return root.val;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        Integer ans = lowestCommonAncestor(4, 7, root);
        System.out.println(ans);
    }
    // Time Complexity is O(N) where N is the total number of Nodes
    // Space Complexity is O(N) where N is the total number of Nodes in Tree,
    // this can only happen when we have skewed tree
}
