package com.shivamkchoudhary;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class CollectionClassExamples {
    public static void main(String[] args) {
        Vector<String> vc = new Vector<>();

        vc.add("Shivam");
        vc.add("Kumar");
        vc.add("Choudhary");
        vc.add("Shivam");
        vc.add("Kumar");
        vc.add("Choudhary");

//        Enumeration<String> en = vc.elements();
//
//        while(en.hasMoreElements()) {
//            System.out.println(en.nextElement());
//        }

        Iterator<String> itr = vc.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
