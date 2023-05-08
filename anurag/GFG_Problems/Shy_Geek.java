package com.anurag.GFG_Problems;

import java.util.Arrays;

public class Shy_Geek {
    static int[] binarySearch(long k, int start, int end) {
        int[] result=new int[2];
        Arrays.fill(result,-1);
        while(start<=end){
            int mid=start+(end-start)/2;
            int price=mid;
            if(price > k) end=mid-1;
            else{
                result[0]=mid;
                result[1]=price;
                start=mid+1;
            }
        }
        return result;
    }
    static long find(int n, long k){
        long result=0;
        int lastIndex=n;
        while(k>0){
            int[] temp=binarySearch(k, 0,lastIndex-1);
            if(temp[0]<0) break;
            else{
                result+=(k/(long)temp[1]);
                k%=temp[1];
                lastIndex=temp[0];
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
