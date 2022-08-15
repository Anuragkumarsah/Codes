package com.anurag.OOPS;

public class overloading {
    double sum(int a, double b, int c){
        return a+b;
    }
    int sum(int a, int b){
        return a+b;
    }

    public static void main(String[] args) {
        overloading ob = new overloading();
        ob.sum(10, 10, 20);
    }
}
