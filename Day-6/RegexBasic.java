package com.shivamkchoudhary;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class RegexBasic {
    public static void main(String[] args) {

//        String re = "..";
//        String re = "\\w*\\W"; //\w -> (a-zA-z0-9_)  \W -> non-char
//        String re = "\\S\\s"; // \s -> space char,  \S -> non-space = any char
//        String re = "\\d\\D"; // \d -> digit char,  \D-> non-digit = any char or space
        String re = "\\w*\\s\\d*";
        String text = "agent 007";

        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(text);

        boolean res = m.matches();
        System.out.println(res);
    }
}
