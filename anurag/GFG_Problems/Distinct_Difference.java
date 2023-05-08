package com.anurag.GFG_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct_Difference {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        Set<Integer> forward_set = new HashSet<>(), backward_set = new HashSet<>();
        Integer[] forward_count = new Integer[N], backward_count = new Integer[N];
        for(int i = 0; i<N;i++) {
            forward_count[i] = forward_set.size();
            forward_set.add(A[i]);
            backward_count[i] = backward_set.size();
            backward_set.add(A[N-1-i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<N;i++) {
            ans.add(forward_count[i] - backward_count[i]);
        }
        return ans;
        // code here
    }
    public static void main(String[] args) {

    }
}
