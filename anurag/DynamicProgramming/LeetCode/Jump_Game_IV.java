package com.anurag.DynamicProgramming.LeetCode;

import java.util.*;

public class Jump_Game_IV {

    public static int minJumps(int[] arr, int pos, Map<Integer, List<Integer>> map, int[] dp, boolean[] visited) {
        if(pos == 0) return 0;
        if(pos > arr.length-1) return (int)1e9;
        if(visited[pos]) return (int)1e9;
        if(dp[pos] != - 1) return dp[pos];
        visited[pos] = true;
        List<Integer> indices = map.get(arr[pos]);
        int min = (int) 1e9;
        for(int index : indices) {
            if (index == pos) continue;
            int jumps = minJumps(arr, index, map, dp, visited) + 1;
            min = Math.min(jumps, min);
        }
        int prev =  minJumps(arr, pos-1, map, dp, visited) + 1;
        int after = minJumps(arr, pos + 1, map, dp, visited) + 1;
        visited[pos] = false;
        return dp[pos] = Math.min(min, Math.min(after, prev));
    }

    public static Map<Integer, List<Integer>> addMatchingIndices(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }
        return map;
    }
    public static boolean canReach(int[] A, int i) {
        System.out.println(Arrays.toString(A));
        return 0 <= i && i < A.length && A[i] >= 0 && ((A[i] = -A[i]) == 0 || canReach(A, i + A[i]) || canReach(A, i - A[i]));
    }
    public static void main(String[] args) {
//        [80,-86,40,12,40,-98,12,-86,-79,-4,-79,71,44,-43,-9,-88,88,-43,31,4,71,-86,55,-9,-65]
//        int[] arr = {80,-86,40,12,40,-98,12,-86,-79,-4,-79,71,44,-43,-9,-88,88,-43,31,4,71,-86,55,-9,-65};
//        boolean[] visited = new boolean[arr.length];
//        Map<Integer, List<Integer>> map = addMatchingIndices(arr);
//        int[] dp = new int[arr.length];
//        Arrays.fill(dp, -1);
//        int count = minJumps(arr, arr.length-1, map, dp, visited);
        int[] A = {3,0,2,1,2};
        System.out.println(canReach(A, 2));
//        System.out.println(A);
    }
}
