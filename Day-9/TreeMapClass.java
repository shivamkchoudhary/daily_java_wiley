package com.shivamkchoudhary;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapClass {
    public static void main(String[] args) {
        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

        tmap.put(1000, "Shivam");
        tmap.put(10000, "Shi");
        tmap.put(2000, "Shiva");
        tmap.put(3000, "Sh");
        tmap.put(6000, "Shop");

        System.out.println(tmap);

        tmap.forEach((k, v) -> System.out.println("key: " + k + " ->val: "+v));
        System.out.println("Last key : "+tmap.lastKey());
        System.out.println("First key :-> " + tmap.firstKey());

        Set<Integer> keysLessThank3k = tmap.headMap(3000).keySet();

        System.out.println(keysLessThank3k);


    }
}
