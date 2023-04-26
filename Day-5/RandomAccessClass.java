package com.shivamkchoudhary;

import java.io.*;
public class RandomAccessClass {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("testfile.txt", "rw");
            file.writeBytes("Hello, Wiley");

            file.seek(0);
            byte[] b = new byte[13];
            file.read(b);
            String data = new String(b);

            System.out.println(data);

            file.seek(7);
            file.writeBytes("Java");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
