package com.anurag.Recurssion;

import java.util.*;

public class Printing_Subsequences {


    static void print(int[] n, ArrayList<Integer> list, int idx){
        if(idx == n.length){
            System.out.println(list);
            return;
        }

        print(n, list, idx+1);
        list.add(n[idx]);

        print(n, list, idx+1);
        list.remove(list.size()-1);
    }
    public static void main (String[] args) {
        int[] arr = {3, 1, 2};
        ArrayList<Integer> list = new ArrayList<>();
        print(arr,list, 0);
    }


}
