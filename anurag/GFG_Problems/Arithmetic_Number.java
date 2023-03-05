package com.anurag.GFG_Problems;

public class Arithmetic_Number {
    static int inSequence(int A, int B, int C){
        // code here
        // t(n) = a + (n-1) d
        // B = A + (x) * C
        // (B - A) / C = x
        // since x is integer, after solving the lhs we should get a integer
        // or in other words B - A must be a multiple of C

        if(C == 0) return A == B ? 1 : 0;
        if( B < A && C > 0) return 0;
        if( B > A && C < 0) return 0;
        if((B - A) % C == 0) return 1;
        return 0;
    }
    public static void main(String[] args) {
        int A = -2, B = -9, C = -7;
        System.out.println(inSequence(A, B, C));
    }
}
