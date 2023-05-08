package com.anurag.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Max_Level_Sum {
    public static void maxLevelSum(Node root, int level, List<Integer> list) {
        if(root == null) return;
        if(list.size() <= level) {
            list.add(root.data);
        }else{
            list.set(level, list.get(level) + root.data);
        }
        maxLevelSum(root.left, level+1, list);
        maxLevelSum(root.right, level+1, list);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Node root = new Node(4);
        maxLevelSum(root, 0, list);
        int max = Integer.MIN_VALUE;
        for(Integer num : list) {
            max = Math.max(max, num);
        }
    }
}
