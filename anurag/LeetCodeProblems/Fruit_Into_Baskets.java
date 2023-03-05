package com.anurag.LeetCodeProblems;

public class Fruit_Into_Baskets {
    public static int totalFruit(int[] fruits) {
        int window_start = 0;
        int[] hash = new int[2];
        int first_number = -1, second_number = -1, max = 0;
        for(int i=0;i<fruits.length;i++){
            if(first_number == -1){
                first_number = fruits[i];
                hash[0] = i;
            }else if(first_number != fruits[i] && second_number == -1){
                second_number = fruits[i];
                hash[1] = i;
            }
            if(first_number == fruits[i]){
                hash[0] = i;
            }
            if(second_number == fruits[i]){
                hash[1] = i;
            }
            if(first_number != fruits[i] && second_number != fruits[i]) {

                if (hash[0] > hash[1]) {
                    window_start = hash[1]+1;
                    second_number = fruits[i];
                    hash[1] = i;

                } else {
                    window_start = hash[0]+1;
                    first_number = fruits[i];
                    hash[0] = i;
                }
            }
//            System.out.println(window_start + "  " + i);
            max = Math.max(max, (i - window_start));
        }
//        max = Math.max(fruits.length-window_start, max);
        return max;
    }
    public static void main(String[] args) {
        int[] fruits = {1,0,3,4,3};
        System.out.println(totalFruit(fruits));
    }
}
