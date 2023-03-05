package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.List;

public class SubSet_Sum_II {
    public static List<List<Integer>> combination(int idx, int[] arr, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=idx;i<arr.length;i++){
            if(i != idx && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            combination(i+1, arr, list, ans);
            list.remove(list.size()-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 3, 3};
        List<List<Integer>> ans = new ArrayList<>();
        combination(0, arr, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}
