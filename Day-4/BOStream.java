package com.shivamkchoudhary;

import java.io.*;

public class BOStream {
    public static void main(String[] args) throws IOException {
//        FileOutputStream fout = new FileOutputStream("C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\Codes\\src\\com\\shivamkchoudhary\\BOStream.txt");
//        BufferedOutputStream bof = new BufferedOutputStream(fout);
//        String str = "I am a Programmer";
//
//        byte[] b = str.getBytes();
////        System.out.println(b);
//
//        try{
//            bof.write(b);
//            bof.flush();
//            bof.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        FileInputStream fin = new FileInputStream("C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\Codes\\src\\com\\shivamkchoudhary\\BOStream.txt");
        BufferedInputStream bin = new BufferedInputStream(fin);
        int i;
        try {
            while ((i = bin.read()) != -1) {
                System.out.print((char) i);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        bin.close();
        fin.close();

    }
}
