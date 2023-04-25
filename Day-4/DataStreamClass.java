package com.shivamkchoudhary;

import java.io.*;

public class DataStreamClass {
    public static void main(String[] args) throws IOException {
//        FileOutputStream fout = new FileOutputStream("C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\Codes\\src\\com\\shivamkchoudhary\\test.txt");
//
//        DataOutputStream dos = new DataOutputStream(fout);
//
//        dos.writeBytes("Hola, this is test");
//        dos.flush();
//        dos.close();
        FileInputStream fin = new FileInputStream("C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\Codes\\src\\com\\shivamkchoudhary\\test.txt");
        DataInputStream dis = new DataInputStream(fin);

        int count = fin.available();
        byte[] b = new byte[count];

        dis.read(b);
        for(byte i : b) {
            System.out.print((char)i);
        }
        dis.close();
        fin.close();
    }
}
