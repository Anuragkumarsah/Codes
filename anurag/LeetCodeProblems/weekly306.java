package com.anurag.LeetCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class weekly306 {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static List<List<Integer>> generate_permutation(int[] arr, int idx, List<Integer> list, List<List<Integer>> ans){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return ans;
        }
        for(int i=idx;i< arr.length;i++){
            swap(arr, i, idx);
            list.add(arr[idx]);
            generate_permutation(arr, idx + 1, list, ans);
            list.remove(list.size() - 1);
            swap(arr, i, idx);
        }
        return ans;
    }
    static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1};
        System.out.println();
    }
}
