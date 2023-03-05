package com.anurag.GFG_Problems;

import java.util.Stack;

public class Geeks_And_The_String {
    public static String removePair(String s) {
        Stack<Character> st = new Stack<>();
        for(char character : s.toCharArray()){
            if(!st.isEmpty() && character == st.peek()) {
                st.pop();
            }else{
                st.push(character);
            }
        }
        if(st.isEmpty()) return "-1";
        StringBuilder sb = new StringBuilder();
        for(char character : st){
            sb.append(character);
        }
        return sb.toString();
    }
    public static void main(String[] args) {

    }
}
