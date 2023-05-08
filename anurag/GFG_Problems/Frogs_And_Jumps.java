package com.anurag.GFG_Problems;

public class Frogs_And_Jumps {
    public int unvisitedLeaves(int N, int leaves, int[] frogs) {
        // Code here
        boolean[] visited = new boolean[N];
        int notVisited = N;
        for(int frog : frogs) {
            int position = frog;
            while(position <= N) {
                if(!visited[position]) {
                    visited[position] = true;
                    notVisited--;
                }
                position += frog;
            }
        }
        return notVisited;
    }
    public static void main(String[] args) {

    }
}
