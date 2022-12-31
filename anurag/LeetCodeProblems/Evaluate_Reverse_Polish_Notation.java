package com.anurag.LeetCodeProblems;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    private static boolean isOperand(String exp){
        return exp.equals("+") || exp.equals("/") || exp.equals("*") || exp.equals("-");
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String exp : tokens) {
            if(!isOperand(exp)){
                st.push(Integer.parseInt(exp));
            }else{
                int a = st.pop();
                int b = st.pop();
                st.push(evaluate(a, b, exp));
            }
        }
        return st.peek();
    }

    private static Integer evaluate(int a, int b, String exp) {
        return switch (exp) {
            case "*" -> b * a;
            case "-" -> b - a;
            case "/" -> b / a;
            default -> a + b;
        };
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
