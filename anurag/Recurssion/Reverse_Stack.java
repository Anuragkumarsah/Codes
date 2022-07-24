package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.Stack;

public class Reverse_Stack {
    public static void reverse(Stack<Integer> s, ArrayList<Integer> list)
    {
        if(s.empty()){
            return;
        }
        list.add(s.peek());
        s.pop();
        reverse(s, list);

    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(7);
        s.push(6);
        ArrayList<Integer> list = new ArrayList<>();
        reverse(s, list);
        System.out.println(list);
    }
}
