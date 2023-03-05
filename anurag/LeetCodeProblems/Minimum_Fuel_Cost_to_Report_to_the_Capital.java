package com.anurag.LeetCodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Fuel_Cost_to_Report_to_the_Capital {
    public static long minimumFuelCost(ArrayList<ArrayList<Integer>> graph, int seats, int[] degree) {
        Queue<Integer> queue = new LinkedList<>();
        long fuel = 0;
        for(int child : degree){
            if(child == 1)
                queue.add(child);
        }
        int[] rep = new int[degree.length];
        Arrays.fill(rep, 1);
        while(!queue.isEmpty()){
            int node = queue.poll();
            fuel += Math.ceil((double) rep[node] / seats);
            for(Integer child : graph.get(node)){
                degree[child]--;
                rep[child] += rep[node];
                if(degree[child] == 1 && child!=0)
                    queue.offer(child);
            }
        }
        return fuel;
    }
    public static void main(String[] args) {
        int[][] roads = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=roads.length;i++){
            graph.add(new ArrayList<>());
        }
        int seats = 2;
        int[] degree = new int[roads.length+1];
        for(int[] edge : roads){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        long ans = minimumFuelCost(graph, seats, degree);
    }
}
