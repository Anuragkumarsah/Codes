package com.anurag.GFG_Problems;

public class Carpet_Into_Box {
    public int carpetBox(int A, int B, int C, int D) {
        if( (A <= C && B <= D) || (A <= D && B <= C)) return 0;

        int min1 = Math.min(A, B);
        int max1 = Math.max(A, B);
        int min2 = Math.min(C, D);
        int max2 = Math.max(C, D);
        int count = 0;
        while(min1 > min2 || max1 > max2){
            if(max1 > max2){
                max1 /= 2;
            }else{
                min1 /=2;
            }
            int copy = min1;
            min1 = Math.min(min1, max1);
            max1 = Math.max(max1, copy);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] input = {131203071, 738050652, 84, 5};
        int A = input[0], B = input[1], C = input[2], D = input[3];
        System.out.println(new Carpet_Into_Box().carpetBox(A, B, C, D));
//        System.out.println(input[1] > Integer.MAX_VALUE);
    }
}
