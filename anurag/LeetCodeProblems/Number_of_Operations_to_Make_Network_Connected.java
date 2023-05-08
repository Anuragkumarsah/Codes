package com.anurag.LeetCodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Number_of_Operations_to_Make_Network_Connected {

    public void dfs(boolean[][] graph, int node, boolean[] visited) {
        if(visited[node]) {
            return;
        }
        visited[node] = true;
        for(int edges = 0; edges < graph.length; edges++) {
            if(graph[node][edges]) dfs(graph, edges, visited);
        }
    }
    public void dfs2(List<List<Integer>> graph, int node, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            node = stack.pop();
            if(visited[node]) continue;
            visited[node] = true;
            for (int edges : graph.get(node)) {
                if (edges == 1) stack.push(edges);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int no_of_edges = connections.length;
        if(no_of_edges < n-1) return -1;
        for(int[] edge : connections) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            dfs2(graph, i, visited);
            count++;
        }
        return count-1;
    }
    public static void main(String[] args) {

    }
}
