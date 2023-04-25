package com.shivamkchoudhary;

import java.util.StringTokenizer;

public class StringTokenClass {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("I love Python programming language");
        StringTokenizer st2 = new StringTokenizer("I, love, Python, programming, language", " ,");
        System.out.println(st.countTokens());
        System.out.println(st2.countTokens());

        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        while(st2.hasMoreTokens()) {
            System.out.println(st2.nextToken());
        }
    }
}
