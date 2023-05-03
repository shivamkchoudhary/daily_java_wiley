package com.shivamkchoudhary;

import java.util.*;

public class SetClass {
    public static void main(String[] args) {
    //        HashSet<String> hs = new HashSet<>();
    //        Set<String> ts = new TreeSet<>();

    //        hs.add("Shivam");
    //        hs.add("Shivam");
    //        hs.add("ShivaM");
    //        hs.add("Kumar");
    //        hs.add("kumar");
    //
    //        System.out.println(hs);

    //        // create an array of string
    //        String[] arr = {"Shivam", "Shivam", "ShivaM", "Kumar", "kumar"};
    //        hs.addAll(List.of((arr)));
    //        System.out.println(hs);

    //
    //        LinkedHashSet<String> lhs = new LinkedHashSet<>();
    //        lhs.add("Shivam");
    //        lhs.add("Shivam");
    //        lhs.add("Mr.");
    //        lhs.add("ShivaM");
    //        lhs.add("Kumar");
    //        lhs.add("kumar");
    //        System.out.println(lhs);
       TreeSet<Integer> ts = new TreeSet<>();

//       ts.add("Shivam");
//       ts.add("Shivam");
//       ts.add("Mr.");
//       ts.add("ShivaM");
//       ts.add("Kumar");
//       ts.add("kumar");

        ts.add(1);
        ts.add(-1);
        System.out.println(ts);
        System.out.println(ts.last().compareTo(ts.first()));

    }
}
