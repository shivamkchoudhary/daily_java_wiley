package com.shivamkchoudhary;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class CharacterStreamClass {
    public static void main(String[] args) throws IOException {
        Writer out = new OutputStreamWriter(System.out);
        Writer fw = new FileWriter("test2.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Hello World. This is test for Character Stream Class.");
        bw.flush();
        bw.close();
        fw.close();

        // read test2 file using


    }
}
