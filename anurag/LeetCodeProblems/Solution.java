package com.anurag.LeetCodeProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DisjointSet {
    int[] parent;
    int[] rank;
    int count;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return;
        }
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[px] = py;
            rank[py]++;
        }
        count--;
    }
    public int getCount() {
        return count;
    }
}
class Solution {

    private int dfs(List<List<Integer>> adj, boolean[] visited, int vertex) {
        int adjListSize = adj.get(vertex).size();
        visited[vertex] = true;
        for (int i = 0; i < adj.get(vertex).size(); i++)
        {
            if (!visited[adj.get(vertex).get(i)])
            {
                adjListSize += dfs(adj, visited, adj.get(vertex).get(i));
            }
        }
        return adjListSize;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Start a new depth-first search from vertex i
                int edg = dfs(adjacencyList, visited, i);
                if(edg/2 == adjacencyList.get(i).size())
                    count++;
            }
        }

        return count;
    }
}