package com.anurag.OnlineJavaClass;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class palindromeserver {
    public static void main(String[] args) throws IOException {Socket s = new Socket("127.0.0.1", 4568);
        System.out.println("Connected to Server");
        DataOutputStream ds = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        System.out.println("put the string");
        String cl_str = sc.next();
        ds.writeUTF(cl_str);
        DataInputStream din = new DataInputStream(s.getInputStream());
        int a = din.read();
        if (a == 1) {
            System.out.println("The String Is Palindrome");}
        else{
            System.out.println("The String Is Not Palindrome");}
        s.close();
    }
}
