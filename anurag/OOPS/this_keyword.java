package com.anurag.OOPS;

public class this_keyword {
    public static void main(String[] args) {
        student anurag = new student();
        anurag.print();
    }
}
class student{
    int roll;
    int marks;
    String name;
    public void print(){
        System.out.println(this);
    }
}
