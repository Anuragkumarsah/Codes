package com.anurag.OnlineJavaClass;

public class ConstructorOverloading {
    int a;
    float b;
    ConstructorOverloading(int a){
        this.a = a;
    }
    ConstructorOverloading(int a, float b){
        this.a = a;
        this.b = b;
    }
    public static void main(String[] args) {
        ConstructorOverloading ob = new ConstructorOverloading(10);

    }
}
