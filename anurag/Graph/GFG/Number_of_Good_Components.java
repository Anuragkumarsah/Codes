package com.anurag.Graph.GFG;

import java.util.ArrayList;

public class Number_of_Good_Components {
    public static int[] visited, c;
    public static int dfs(ArrayList<ArrayList<Integer>> adj, int row) {
        if(visited[row] != 0) {
            return 0;
        }
        visited[row] = 1;
        c[0]++;
        int count = 0;
        for(int i=0;i<adj.get(row).size();i++){
            count += dfs(adj, adj.get(row).get(i));
        }
        return count + adj.get(row).size();
    }
    public static int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new int[V+1];

        int count = 0;
        for(int i=1;i<=V;i++){
            c = new int[1];
            if(visited[i] == 0){
               int cs = dfs(adj, i) / 2;
               long calc = ((long) c[0] * (long)(c[0] - 1))/2;
               if(calc == cs){
                   count++;
               }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 7;
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(7);
        adj.get(7).add(2);
        adj.get(3).add(5);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(3);
        System.out.println(findNumberOfGoodComponent(V, adj));
    }
}
