package com.anurag.Binary_Tree;

import java.util.ArrayList;

public class Right_And_Left_View_of_A_Binary_Tree {
    public static void RightView(TreeNode root, int level, ArrayList<Integer> Right_ans){
        if(root == null)
            return;
        //This if ensures that I only take the first node of the level of the Binary Tree
        // So if I am at level is 2 and my size of the data structure is 2 that means
        // that I am visiting that node first time, so I have to include it into my ans

        if(level == Right_ans.size()){
            Right_ans.add(root.val);
        }

        //Always trying to take the right path so that I can get the right look of the binary tree

        RightView(root.right, level+1, Right_ans);
        RightView(root.left, level+1, Right_ans);
    }

    public static void LeftView(TreeNode root, int level, ArrayList<Integer> Left_ans){
        if(root == null)
            return;
        if(level == Left_ans.size()){
            Left_ans.add(root.val);
        }
        //Same approach as the Right View but this time we are taking the left path first
        LeftView(root.left, level+1, Left_ans);
        LeftView(root.right, level+1, Left_ans);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> Right_ans = new ArrayList<>();
        ArrayList<Integer> Left_ans = new ArrayList<>();
        RightView(root, 0, Right_ans);
        LeftView(root, 0, Left_ans);
        System.out.println("The Right view is: "+Right_ans);
        System.out.println("The Left view is: "+Left_ans);
    }
    // Time Complexity is O(N) where N is the total number of nodes
    // Space Complexity for recursion approach can be O(N) when we are having a skewed tree
    // But the average space complexity is O(H) where H is the Height of the Tree.
}
