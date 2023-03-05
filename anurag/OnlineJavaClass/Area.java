package com.anurag.OnlineJavaClass;

public class Area {
    public static double area(int radius){
        return Math.PI * radius * radius;
    }
    public static double area(float base, float height){
        return (0.5 * base * height);
    }
    public static int area(int length, int breadth){
        return (length * breadth);
    }
    public static void main(String[] args) {
        double circle = area(10);
        double triangle = area(10.5f, 5.4f);
        int square = area(10, 10);
        int rectangle = area(5, 10);
        System.out.println("Area of the circle is: "+ circle +" units");
        System.out.println("Area of the triangle is: "+ triangle +" units");
        System.out.println("Area of the square is: "+ square +" units");
        System.out.println("Area of the rectangle is: "+ rectangle +" units");
    }
}
