package com.anurag.OnlineJavaClass;
import java.util.*;

class PrimeNumbers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println("Prime numbers between "+start+" and "+end+" are : ");
        try{
            for(int i=start;i<=end;i++){
                boolean isPrime = true;
                for(int j=2;j<i;j++){
                    if(i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if( isPrime ) System.out.println(i);
            }
        } catch( Exception e){
            e.printStackTrace();
        }
    }
}