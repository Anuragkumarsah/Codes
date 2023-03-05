package com.anurag.Binary_Tree;

public class BST_Downward_Traversal {
    static Node findTarget(Node root, int target) {
        if(root == null) return null;
        if(root.data == target) return root;
        if(root.data > target) return findTarget(root.left, target);
        else return findTarget(root.right, target);
    }
    static long traverseVertically (Node root, int position){
        if(root == null) return 0;
        long left = traverseVertically(root.left, position+1);
        long right = traverseVertically(root.right, position-1);
        return (position == 0 ? root.data : 0) + left + right;
    }
    static long verticallyDownBST(Node root,int target) {
        Node result = findTarget(root, target);
        if(result == null) return -1;
        return traverseVertically(result, 0) - result.data;
    }

    public static void main(String[] args) {
        Node root = new Node(25);
        root.right = new Node(35);
        root.left = new Node(20);
        root.left.right = new Node(22);
        root.left.left = new Node(15);
        root.right.right = new Node(45);
        root.right.left = new Node(30);
        root.right.left.right = new Node(32);
        int target = 25;
        System.out.println(verticallyDownBST(root, target));
    }
}
