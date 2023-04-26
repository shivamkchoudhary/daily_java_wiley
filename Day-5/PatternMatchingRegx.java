package com.shivamkchoudhary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchingRegx {
    public static void main(String[] args) {
        String input = "The key to learn programming is practice";

        Pattern p = Pattern.compile("learn");
        Matcher m = p.matcher(input);

        if(m.find()) {
            int start = m.start();
            int end = m.end();

            System.out.println("Found at: " + start + " to " + (end-1));
        }
    }
}
