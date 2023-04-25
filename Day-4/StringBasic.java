package com.shivamkchoudhary;

public class StringBasic {
    public static void main(String[] args) {
        String name = "Shivam";
        String test = "Shivam";
        String test2 = new String("Shivam");
        String test3 = new String("Shivam");

//        System.out.println(name);
//        System.out.println(test.charAt(0));
//        System.out.println(test2.length());
//        System.out.println(name == test);
//        System.out.println(name == test2);
//        System.out.println(name.equals(test));
//        System.out.println(test2 == test3);
        String name2 = "Testing this string with a lot of words";
        System.out.println(name2.indexOf("this"));
        System.out.println(name2.charAt(10));
        String test4 = name.concat(" ").concat(name2);
        System.out.println(test4);
        System.out.println(name2.replace('t', 'l'));
        System.out.println(name2.replace("words", "word"));


        String sarray[] = name.split("");
        for (String s : sarray) {
            System.out.println(s);
        }
        char sarray2[] = name2.toCharArray();
        for (char s : sarray2) {
            System.out.println(s);
        }
    }
}
