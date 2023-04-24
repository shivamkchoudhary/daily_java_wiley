package com.shivamkchoudhary;

import java.util.ArrayList;

class StringNotFound extends RuntimeException {
    public StringNotFound(String message) {
        super(message);
    }
}
public class UnCheckedExce {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Shivam");
        students.add("Rahul");
        students.add("Sohan");

        if(!students.contains("Shivaml")) {
            try{
                throw new StringNotFound("String not found");
            } catch (StringNotFound stringNotFound) {
                stringNotFound.printStackTrace();
            }
        }
        System.out.println("Message 1");
        System.out.println("Message 2");
    }
}
