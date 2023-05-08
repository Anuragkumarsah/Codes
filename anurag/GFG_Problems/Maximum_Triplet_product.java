package com.anurag.GFG_Problems;

public class Maximum_Triplet_product {
    Long maxTripletProduct(Long[] arr, int n)
    {
        long max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(long num : arr) {
            if(max <= num){
                max3 = max2;
                max2 = max;
                max = num;
            } else if(max2 <= num) {
                max3 = max2;
                max2 = num;
            }else if(max3 <= num) {
                max3 = num;
            }

            if(min >= num) {
                min2 = min;
                min = num;
            }else if(min2 >= num) {
                min2 = num;
            }
        }
        long all_max = max * max2 * max3;
        long two_min = min * min2 * max;
        return Math.max(all_max, two_min);
    }
    public static void main(String[] args) {

    }
}
