package com.anurag.GFG_Problems;

import java.util.Stack;

public class Next_Greater_Element {
    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        long[] ans = new long[n];
        Stack<Long> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                while(!st.isEmpty() && arr[i] >= st.peek()){
                    st.pop();
                }
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
