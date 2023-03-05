package com.anurag.Binary_Tree;


import java.util.*;

class Pair{
    TreeNode node;
    int line;
    Pair(TreeNode node, int line){
        this.node = node;
        this.line = line;
    }
}

public class Top_View_Of_A_Binary_Tree {
    static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.line;
            TreeNode temp = it.node;
            map.computeIfAbsent(hd, k -> temp.val);
            if (temp.left != null) {

                q.add(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null) {

                q.add(new Pair(temp.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

        // The Time Complexity will be O(N) solution, where N is the number of nodes
        // The Space Complexity will be O(N)
    }
}
