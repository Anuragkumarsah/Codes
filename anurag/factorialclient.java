package com.anurag;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class factorialclient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 4568);
        System.out.println("Connected to Server");
        DataOutputStream ds = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        System.out.println("write the number");
        int a = sc.nextInt();
        ds.write(a);
        DataInputStream din = new DataInputStream(s.getInputStream());
        int aa = din.readInt();
        System.out.println("The Factorial Value Came From Server is : " + aa);
    }
}