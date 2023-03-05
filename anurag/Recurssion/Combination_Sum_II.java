package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Combination_Sum_II {
    static void check(int idx, int target, HashSet<ArrayList<Integer>> res, int[] candidates, ArrayList<Integer> list){
        if(idx == candidates.length ){
            if(target == 0){
                res.add(new ArrayList<>(list));
            }
          return;
        }

        if(target >= candidates[idx]) {
            target -= candidates[idx];
            list.add(candidates[idx]);
            check(idx + 1, target, res, candidates, list);
            target += candidates[idx];
            list.remove(list.size() - 1);
        }
        check(idx+1, target, res, candidates, list);
    }
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Arrays.sort(candidates);
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        check(0, target, res, candidates, new ArrayList<>());
        System.out.println(res);
    }
}
