package com.anurag.pca2;

import java.util.*;

class NoMatchFoundException extends Exception {
    NoMatchFoundException() {
        System.out.println("This string does not have 'University' ");
    }
}
public class pca2q4 {

        public static void main(String[] args) {
            Scanner st = new Scanner(System.in);
            System.out.println("Enter the number of strings to be inputted: ");
            String[] str = new String[st.nextInt()];
            st.nextLine();
            for (int i = 0; i < str.length; i++) {
                System.out.println("Enter the string no :" + (i+1));
                str[i] = st.nextLine();
            }
            try {
                int flag = 0;
                for (String s : str) {
                    if (s.equals("University")) {
                        flag = 0;
                    } else
                        flag = -1;
                }
                if (flag == 0) {
                    System.out.println("Found ");
                } else
                    throw new NoMatchFoundException();
            } catch (Exception e) {
                System.out.println("Catch: " + e);
            }
        }
}
