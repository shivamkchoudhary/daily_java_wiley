package com.shivamkchoudhary;

public class StringBufferClass {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("Shivam");
        StringBuffer sb2 = new StringBuffer("Shivam");
        String test = "Shivam";
        System.out.println(sb1);
        System.out.println(sb2.equals(sb1));
        System.out.println(test.equals(sb1.toString()));
//        sb1.append(" Choudhary");
//        System.out.println(sb1);
        sb1.insert(6, " Kumar");
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);
        sb1.delete(0, 6);
        System.out.println(sb1);
    }
}
