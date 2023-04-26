package com.shivamkchoudhary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("test.txt");

        String str = "Hello World!";

        byte[] b = str.getBytes();

        fout.write(b);
        fout.flush();
        fout.close();

        // read from the test file just saved using FileOutputStream

        FileInputStream fin = new FileInputStream("test.txt");
        int i = 0;
        while ((i = fin.read()) != -1) {
            System.out.print((char) i);
        }

    }
}
