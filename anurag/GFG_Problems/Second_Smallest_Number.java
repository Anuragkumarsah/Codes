package com.anurag.GFG_Problems;

import java.math.BigInteger;

public class Second_Smallest_Number {
    public static BigInteger getPosition(String num) {
        int i = num.length()-1;
        BigInteger one = BigInteger.valueOf(1), ten = BigInteger.valueOf(10);
        BigInteger mul = BigInteger.valueOf(1);
        while(num.charAt(i) == '9') {
            i--;
            mul = mul.multiply(ten);
        }
        return (mul.compareTo(one) > 0 ? (mul.divide(ten)) : one).multiply(BigInteger.valueOf(9));
    }
    public static String secondSmallest(int S, int D){
        // code here
        if(9*D <= S) return "-1";
        BigInteger sum = new BigInteger("0");
        BigInteger one = new BigInteger("1"), ten = new BigInteger("10");
        while(D > 0) {
            if(D*9 < S) {
                sum = sum.add(one);
                S--;
            } else {
                if(D == 1) {
                    BigInteger big_S = BigInteger.valueOf(S);
                    sum = sum.multiply(ten).add(big_S);
                    S--;
                }else if(sum.compareTo(new BigInteger("0")) > 0) {
                    sum = sum.multiply(ten);
                }else {
                    sum = sum.multiply(ten).add(one);
                    S--;
                }
                D--;
            }

        }
        sum = sum.add(getPosition(sum.toString()));
        return sum.toString();
    }
    public static void main(String[] args) {
        int S = 69874, D = 79636;
        System.out.println(secondSmallest(S, D));
    }
}
