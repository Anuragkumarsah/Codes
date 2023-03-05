package com.anurag.Graph.LeetCode;

import java.util.*;

public class Shortest_Path_with_Alternating_Colors {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(visited.contains(node)) continue;
            visited.add(node);
            ans.add(node);
            for(Integer child : adj.get(node)){
                queue.offer(child);
            }
        }
        return ans;
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited.contains(node)) continue;
            visited.add(node);
            ans.add(node);
            for(int i=adj.get(node).size() - 1;i>=0;i++){
                stack.push(adj.get(node).get(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
