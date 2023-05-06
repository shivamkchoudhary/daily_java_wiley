package com.shivamkchoudhary;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeClass {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new ConcurrentHashMap<>();
        myMap.put(1, "Shivam");
        myMap.put(2, "Kumar");
        myMap.put(3, "Choudhary");

        Iterator<Integer> iterator = myMap.keySet().iterator();

        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key + " : " + myMap.get(key));
            myMap.put(4, "Shivam");
        }
    }
}
