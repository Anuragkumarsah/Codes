package com.anurag.pca2;

import java.util.*;
public class pca2q2 {
    public static void main(String[] args) {

        num obj1=new num();
        num obj2=new Hexnum();

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value of n:");
        int a=sc.nextInt();
        obj1.n=a;
        obj2.n=a;
        obj1.showNum();
        obj2.showNum();

    }
}

class num
{
    int n;
    void showNum()
    {
        System.out.println("n in decimal is ="+n);

    }
}

class Hexnum extends num
{
    @Override
    void showNum()
    {
        System.out.println("n in hex is ="+Integer.toHexString(n));

    }
}

