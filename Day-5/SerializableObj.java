package com.shivamkchoudhary;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
public class SerializableObj {
    public static void main(String[] args) {
        Book b1 = new Book(108, "Java Essentials");

        try{
            FileOutputStream fout = new FileOutputStream("books.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(b1);
            fout.flush();
            System.out.println("Success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
