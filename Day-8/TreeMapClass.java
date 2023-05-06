package com.shivamkchoudhary;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.sun.source.tree.Tree;

public class TreeMapClass {
    public static void main(String[] args) {

        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

        tmap.put(1000, "Venkat");
        tmap.put(1300, "shivam");
        tmap.put(2000, "rishav");
        tmap.put(3000, "sachin");
        tmap.put(11000, "jahnavi");

        //sorted and printing basis on key
//		System.out.println(tmap);
//
//		tmap.forEach( (k, v) -> System.out.println("key: " + k + " - val: " + v) );
//		System.out.println("Last key: " + tmap.lastKey());
//		System.out.println("First key: " + tmap.firstKey());
//
//		Set<Integer> keysLessThan3k = tmap.headMap(3000).keySet();
//
//		System.out.println(keysLessThan3k);
//
//		Set<Integer> keysLessGrThan3k = tmap.tailMap(3000).keySet();
//
//		System.out.println(keysLessGrThan3k);

        ////

        TreeMap<String, Integer> userMap = new TreeMap<String, Integer>();

        userMap.put("venkat", 108);
        userMap.put("shivam", 109);
        userMap.put("sachin", 81);
        userMap.put("rohit", 91);
        userMap.put("praveen", 18);
        userMap.put("muskan", 28);

        userMap.forEach( (k, v) -> System.out.println("key: " + k + " - val: " + v) );


    }
}
