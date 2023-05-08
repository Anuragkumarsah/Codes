package com.anurag.LeetCodeProblems;

public class Weekly_Contest_337_1 {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0, pos = 0;
        while(n > 0) {
            if((n & 1) == 1){
                if(pos % 2 == 0) {
                    even++;
                }else {
                    odd++;
                }
            }
            pos++;
            n = n>>1;
        }
        return new int[]{even, odd};
    }
    public static void main(String[] args) {

    }
}
