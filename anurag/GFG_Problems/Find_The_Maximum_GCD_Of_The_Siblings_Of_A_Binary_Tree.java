package com.anurag.GFG_Problems;

import com.anurag.DynamicProgramming.GFG.Node;

class Pair{
    int value;
    int gcd;
    public Pair(int value, int gcd){
        this.value = value;
        this.gcd = gcd;
    }
}

public class Find_The_Maximum_GCD_Of_The_Siblings_Of_A_Binary_Tree {

    public static int getGCD(int num1, int num2){
        if(num1 == 0) return num2;
        return getGCD(num2 % num1, num1);
    }
    public static Pair maxGCD(Node root) {
        // code here
        if(root == null) return new Pair(-1, 1);
        int parent_gcd = getGCD(root.left != null ? root.left.data : 1, root.right != null ? root.right.data : 1);
        Pair left_child_gcd = maxGCD(root.left);
        Pair right_child_gcd = maxGCD(root.right);
        Pair max_child_gcd ;
        if(left_child_gcd.gcd > right_child_gcd.gcd){
            max_child_gcd = left_child_gcd;
        }else if(left_child_gcd.gcd < right_child_gcd.gcd){
            max_child_gcd = right_child_gcd;
        }else{
            max_child_gcd = left_child_gcd.value > right_child_gcd.value ? left_child_gcd : right_child_gcd;
        }
        if(parent_gcd == max_child_gcd.gcd) return (max_child_gcd.value > root.data ? max_child_gcd : new Pair(root.data, parent_gcd));
        return Math.max(parent_gcd, max_child_gcd.gcd) == parent_gcd ? new Pair(root.data, parent_gcd) : max_child_gcd;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(3);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(12);
        root.right.right = new Node(1);

        System.out.println(maxGCD(root).value);
    }
}
