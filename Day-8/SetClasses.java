package com.shivamkchoudhary;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetClasses {
    public static void main(String[] args) {

        NavigableSet<String> ts = new TreeSet<String>();

        //Set<String> ts = new TreeSet<String>();

// 		Human parent class
//		Person extends human
//		Student extends Person
        //- new methods

        // Human st = new Student();

        ts.add("h");
        ts.add("b");
        ts.add("b");
        ts.add("w");
        ts.add("a");

        System.out.println(ts);
        System.out.println(ts.first());
        System.out.println(ts.last());
        System.out.println(ts.headSet("b")); // < obj
        System.out.println(ts.tailSet("h")); // >=obj
        System.out.println(ts.subSet("b","w"));// >= obj1 and < obj2

        System.out.println(ts);

        System.out.println(ts.descendingSet());
    }
}