package com.anurag.Sorting;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();

        for (int caseId = 1; caseId <= numCases; caseId++) {
            // Inputs
            int num = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();


            int sum = (num*(num+1))/2;
            int current_Sum = 0;
            // Setup
            String ans = "IMPOSSIBLE";
           int resx = 0, resy = 0, flag = 0;
            for (int i = 1; i <= num; i++) {
                for (int j = i; j <= num; j++) {
                    current_Sum += j;
                    if(((float)current_Sum/(float)(sum - current_Sum)) == (float)x/(float)y){
                        resx = i;
                        resy = j;
                        ans = "POSSIBLE";
                        flag = 1;
                }
                    current_Sum = 0;
            }



                // Processing
            }

            // Print results
            // String ans = new DecimalFormat("#0.000000000000").format(someFloatorDouble);
            p("Case #" + caseId + ": " + ans);
            if(flag == 1){
                System.out.println(Math.max(resy-resx, 1));
                for (int i = resx; i < resy; i++) {
                    System.out.print(i+" ");
                }
                System.out.print(resy);
            }

        }
    }

    //////////

    private static void p() {
        p("");
    }

    private static void p(String s) {
        System.out.println(s);
    }
}