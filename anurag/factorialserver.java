package com.anurag;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class factorialserver {
    public static void main(String[] args) throws IOException {
        System.out.println("This is Server Sending Request");
        ServerSocket ss = new ServerSocket(4568);
        System.out.println("Connection Established");
        Socket s = ss.accept();
        System.out.println("Request Accepted");
        DataInputStream di = new DataInputStream(s.getInputStream());
        int a = di.read();
        System.out.println("The Value Came From Client Is : " + a);int f = 1;
        for (int i = 1; i <= a; i++) {
            f = f * i;
        }
        DataOutputStream ds=new DataOutputStream(s.getOutputStream());
        ds.writeInt(f);}}