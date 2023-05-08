package com.anurag.LeetCodeProblems;

import java.util.Stack;

public class BrowserHistory {
    public Stack<String> back, forward;
    private String current_url;
    private boolean print;
    public BrowserHistory(String homepage) {
        this.back = new Stack<>();
        this.forward = new Stack<>();
        this.current_url = homepage;
    }

    public void visit(String url) {
        this.back.push(current_url);
        this.current_url = url;
        this.forward = new Stack<>();
        if(print)
            System.out.println("visit : {"+back+", "+forward+"}" + " "+current_url);
    }

    public String back(int steps) {
        if(this.back.isEmpty()){
            if(print)
                System.out.println("back : {"+back+", "+forward+"}" +" "+ current_url);
            return this.current_url;
        }
        this.forward.push(this.current_url);
        this.current_url = this.back.pop();
        for(int i=1;i<steps;i++) {
            if(this.back.isEmpty()) {
                if(print)
                    System.out.println("back : {"+back+", "+forward+"}" +" "+ current_url);
                return this.current_url;
            }
            String url = this.back.pop();
            this.forward.push(current_url);
            this.current_url = url;
        }
        if(print)
            System.out.println("back : {"+back+", "+forward+"}" +" "+ current_url);
        return this.current_url;
    }

    public String forward(int steps) {
        if(this.forward.isEmpty()){
            if(print)
                System.out.println("forward : {"+back+", "+forward+"}" +" "+ current_url);
            return this.current_url;
        }
        this.back.push(this.current_url);
        this.current_url = this.forward.pop();
        for(int i=1;i<steps;i++) {
            if(this.forward.isEmpty()) {
                if(print)
                    System.out.println("forward : {"+back+", "+forward+"}" +" "+ current_url);
                return this.current_url;
            }
            String url = this.forward.pop();

            this.back.push(current_url);
            this.current_url = url;
        }
        if(print)
            System.out.println("forward : {"+back+", "+forward+"}" +" "+ current_url);
        return this.current_url;
    }
    public static void main(String[] args) {
        BrowserHistory ob = new BrowserHistory("icpbj.com");
        ob.print = false;
        System.out.println(ob.back(1));
        System.out.println(ob.back(10));
        ob.visit("xbepk.com");
        System.out.println(ob.forward(8));
        ob.visit("kls.com");
        ob.visit("dlkwxpf.com");
        ob.visit("pnep.com");
        System.out.println(ob.back(9));
        ob.visit("rmis.com");
        ob.visit("bxf.com");
        ob.visit("dz.com");
        System.out.println(ob.back(2));
        ob.visit("acuqsax.com");
        ob.visit("dcvo.com");
        ob.visit("ijbg.com");
        ob.visit("nlott.com");
        System.out.println(ob.back(7));
        ob.visit("dd.com");
        ob.visit("vssnq.com");
        ob.visit("teur.com");
        ob.visit("pn.com");
        ob.visit("szi.com");
        ob.visit("brhldg.com");
        ob.visit("yulyoqv.com");
        System.out.println(ob.back(4));
        System.out.println(ob.forward(10));
        System.out.println(ob.back(8));
        System.out.println(ob.forward(5));
        ob.visit("av.com");
        System.out.println(ob.back(3));

    }
}
