package com.shivamkchoudhary;

import java.util.Hashtable;

public class HashTableClass {
    public static void main(String[] args) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        ht.put(1, 100);
        ht.put(2, 200);
        ht.put(3, 300);
        ht.put(4, 400);
        ht.put(5, 500);
        ht.remove(3);
        System.out.println(ht);
    }
}
