package com.anurag.GFG_Problems;

import java.util.Stack;

public class Asteroid_Collision {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int asteroid : asteroids){
            if(asteroid > 0){
                st.push(asteroid);
            } else{
              if(st.isEmpty() || st.peek() < 0){
               st.push(asteroid);
              }
              else {
                  if(st.peek() > -asteroid) continue;
                  else if(st.peek() == -asteroid) st.pop();
                  else {
                      while( !st.isEmpty() && st.peek() > 0 && st.peek() < -asteroid) st.pop();
                      if(!st.isEmpty() && st.peek() < 0) st.push(asteroid);
                      if(!st.isEmpty() && st.peek() == -asteroid) st.pop();
                  }
                  if(st.isEmpty()) st.push(asteroid);
              }
            }
        }
        int[] ans = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] pk = new int[]{-1, -7, -3, -12, -1, -8};
        int[] ans = asteroidCollision(6, pk);
        for(int a : ans) System.out.println(a);
    }
}
