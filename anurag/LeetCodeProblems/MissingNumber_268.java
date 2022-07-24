package com.anurag.LeetCodeProblems;

import java.util.Arrays;

public class MissingNumber_268 {
    public static void main(String[] args) {
        int [] arr = new int[]{7, 6, 5, 4, 3, 2, 1};
        int i = 0, first_number, second_number;
        while(i < 7){
            if(arr[i] == (i+1)){
                i++;
            } else {
                first_number = arr[i];
                second_number = arr[arr[i]-1];
                first_number = first_number^second_number;
                second_number = first_number^second_number;
                first_number = first_number^second_number;
                arr[i] = first_number;
                arr[second_number-1] = second_number;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
