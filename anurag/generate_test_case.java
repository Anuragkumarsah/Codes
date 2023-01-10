package com.anurag;

public class generate_test_case {
    public static void main(String[] args) {
        System.out.print("[");
        for(int i=0;i<5;i++){
            System.out.print("[");
            for(int j=0;j<9;j++){
                int n = (int)(Math.random()*100);
                System.out.print(n+", ");
            }
            System.out.print("],");
        }
        System.out.print("]");
    }
}
