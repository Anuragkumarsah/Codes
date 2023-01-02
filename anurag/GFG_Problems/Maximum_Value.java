package com.anurag.GFG_Problems;

import com.anurag.DynamicProgramming.GFG.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Value {

//    https://practice.geeksforgeeks.org/problems/ec277982aea7239b550b28421e00acbb1ea03d2c/1

    static ArrayList<Integer> maximumValue(Node node) {
        // we check whether the node is null, if null then we return an empty arraylist
        if(node == null) return new ArrayList<>();
        // we use the level order traversal in this and store the max element
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int len = queue.size();
            int max = 0;
            for (int i = 0; i < len; i++) {
                Node current = queue.poll();
                assert current != null;
                max = Math.max(max, current.data);
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            ans.add(max);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        System.out.println(maximumValue(root));
    }
}
