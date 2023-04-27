package com.shivamkchoudhary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DivideClass {
    public static void main(String[] args) {

        Pattern p = Pattern.compile("^(\\d+) divide by (\\d+)$");
        Matcher m = p.matcher("10 divide by 5");

        if(m.find()){
            String message = "result = " + m.replaceFirst("$1, $2");
            System.out.println(message);

            int res = Integer.valueOf(m.group(1)) / Integer.valueOf(m.group(2));

            System.out.println("Final result : "+ res);
        }

    }
}
