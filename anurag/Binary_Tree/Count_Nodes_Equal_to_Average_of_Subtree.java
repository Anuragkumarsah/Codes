package com.anurag.Binary_Tree;

import java.util.ArrayList;
import java.util.HashSet;
class pier{
    int sum = 0;
    int nodeCount = 0;
    public pier(int sum, int nodeCount){
        this.sum = sum;
        this.nodeCount = nodeCount;
    }
}
public class Count_Nodes_Equal_to_Average_of_Subtree {
    static int ans = 0;
    public static pier averageOfSubtree(TreeNode root) {
        if(root == null){
            return new pier(0,0);
        }
        pier leftSum = averageOfSubtree(root.left);
        pier rightSum = averageOfSubtree(root.right);
        System.out.println((leftSum.nodeCount+rightSum.nodeCount+1)+" "+root.val+" "+(leftSum.sum+rightSum.sum+root.val));
        if((leftSum.sum+rightSum.sum+root.val)/(leftSum.nodeCount+rightSum.nodeCount+1) == root.val) {

            ans++;
        }
        return new pier((leftSum.sum+rightSum.sum+root.val), (leftSum.nodeCount+rightSum.nodeCount+1));
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
//        System.out.println(averageOfSubtree(root, 0));
        averageOfSubtree(root);
        System.out.println(ans);
//        System.out.println(ans);
//        System.out.println(averageOfSubtree(root, new ArrayList<>(), hs));
    }
}
