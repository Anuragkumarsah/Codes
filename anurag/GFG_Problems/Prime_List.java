package com.anurag.GFG_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prime_List {
    public static List<Integer> getPrime(){
        boolean[] sieve = new boolean[10_011];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        List<Integer> prime = new ArrayList<>();
        for(int i = 2;i<10_010;i++){
            if(sieve[i]){
                prime.add(i);
                for(int j = 2;;j++){
                    if(i*j > 10_010)break;
                    sieve[i*j] = false;
                }
            }
        }
        return prime;
    }
    public static void main(String[] args) {
        List<Integer> prime = getPrime();
        System.out.println(prime);
    }
}
