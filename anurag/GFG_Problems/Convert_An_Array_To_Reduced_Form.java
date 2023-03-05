package com.anurag.GFG_Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Convert_An_Array_To_Reduced_Form {
    static void convert(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            map.put(arr[i], i);
            pq.offer(arr[i]);
        }
        int number = 0;
        while(!pq.isEmpty()){
            int index = map.get(pq.poll());
            arr[index] = number;
            number++;
        }

    }
    public static void main(String[] args) {

    }
}
