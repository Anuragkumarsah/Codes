package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.List;

public class Array_Permutation_Brute_Force {
    public static List<List<Integer>> generate_permutation(int[] arr,int[] map, List<Integer> list, List<List<Integer>> ans){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return ans;
        }
        for(int i=0;i< arr.length;i++){
            if(map[i]==0){
                map[i] = 1;
                list.add(arr[i]);
                generate_permutation(arr, map, list, ans);
                list.remove(list.size()-1);
                map[i] = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();

        System.out.println(generate_permutation(arr, new int[arr.length], new ArrayList<>(), ans));
    }
}
