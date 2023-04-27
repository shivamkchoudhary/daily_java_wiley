package com.shivamkchoudhary;

import java.util.regex.*;

public class PatterMatch {
    public static void main(String[] args) {

//        Pattern p = Pattern.compile("\\w*\\s\\d{3,5}"); // Takes {min, max}
        Pattern p = Pattern.compile("^[a|A]gent (\\d{3,4})$");
        Matcher m = p.matcher("agent 0007");
//
//        boolean found = m.find(); // Find at least -> 2222 -> finding 22 in this -> True
//        boolean match = m.matches(); // find or match exact -> same as above -> False


        if(m.find()) {
            System.out.println("Group : " + m.group());
            System.out.println("Group : " + m.group(1));
        }
//
//        System.out.println("Found : " + found);
//        System.out.println("Matched : " + match);

    }
}
