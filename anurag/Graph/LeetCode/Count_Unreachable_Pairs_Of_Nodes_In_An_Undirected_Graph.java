package com.anurag.Graph.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Count_Unreachable_Pairs_Of_Nodes_In_An_Undirected_Graph {
    public static int count;
    public void dfs(List<List<Integer>> graph, int row, boolean[] visited) {
        for(int edge : graph.get(row)){
            if (visited[edge]) continue;
            visited[edge] = true;
            count++;
            dfs(graph, edge, visited);
        }
    }
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        count = 0;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        long ans = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            count = 0;
            if(visited[i]) continue;
            visited[i] = true;
            count++;
            dfs(graph, i, visited);
            ans += ((long) count * (n - count));
        }
        return ans/2;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        int n = 7;
        Count_Unreachable_Pairs_Of_Nodes_In_An_Undirected_Graph ob = new Count_Unreachable_Pairs_Of_Nodes_In_An_Undirected_Graph();
        System.out.println(ob.countPairs(n, edges));
    }
}
