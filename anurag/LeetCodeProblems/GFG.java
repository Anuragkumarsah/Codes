package com.anurag.LeetCodeProblems;

/*package whatever //do not write package name here */

import java.util.*;

public class GFG {
    static void BFS(ArrayList<ArrayList<Integer>> adj, int V, int[] dist) {
        int[] visited = new int[V];
        for(int i = 0; i < V; i++)
            visited[i] = 0;

        Queue<Integer>  q = new LinkedList<>();

        visited[0] = 1;
        q.offer(0);

        while(!q.isEmpty())
        {
            int u = q.peek();
            q.poll();

            for(int v : adj.get(u)){
                if(visited[v]<=2){
                    dist[v]=dist[u]+1;
                    visited[v]++;
                    q.offer(v);
                }
            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V=4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        BFS(adj,V, dist);

        for(int i=0;i<V;i++){
//            cout<<dist[i]<<" ";
            System.out.println(dist[i]+" ");
        }
    }

}

// This code is contributed by ayush123ngp.

