package com.anurag.GFG_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Yet_Another_Query_Problem {
    public static void countElements(int N, int[] A, List<Map<Integer, Integer>> list_map) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            list_map.add(new HashMap<>(map));
        }
    }
    public static ArrayList<Integer> solveQueries(int N, int num, int[] A, int[][] Q) {
        // code here
        List<Map<Integer, Integer>> list_map = new ArrayList<>(N+1);
        countElements(N, A, list_map);
        Map<Integer, Integer> map = list_map.get(N-1);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<num;i++) {
            int L = Q[i][0], R = Q[i][1], K = Q[i][2];
            int count = 0;
            for(int j=L;j<=R;j++) {
                int freq = map.get(A[j]) - list_map.get(j).getOrDefault(A[j], 0) + 1;
                if(freq == K) {
                    count++;
                }
            }
            ans.add(count);
        }
        return ans;
    }
    public static void main(String[] args) {
        int N = 5;
        int[] A = {1,1,3,4,3};
        int[][] Q = {{0,2,2},{0,2,1},{0,4,2}};
        int num = 3;
        System.out.println(solveQueries(N, num, A, Q));
    }
}
