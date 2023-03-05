package com.anurag.LeetCodeProblems;

public class Min_operations_make_number_0 {

    public static int minOperations(int n) {
        if(n == 0) return 0;
        int lo = (int) Math.floor((Math.log(n))/Math.log(2));
        int hi = (int) Math.ceil((Math.log(n))/Math.log(2));
        double abs = Math.abs(Math.pow(2, hi) - n);
        if(Math.abs(Math.pow(2,lo) - n) > abs) return 1 + minOperations((int) abs);
        return 1+minOperations((int) Math.abs(Math.pow(2, lo) - n));

    }
    public static void main(String[] args) {
        int n = 39;
        System.out.println(minOperations(n));
    }
}
