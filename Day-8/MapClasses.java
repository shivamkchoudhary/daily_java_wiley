package com.shivamkchoudhary;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapClasses {
    public static void main(String[] args) {
//		Map<String, String> ss = new HashMap<String, String>();
//
//		ss.put("a", "A");
//		ss.put("b", "B");
//		ss.put("c", "C");
//
//		ss.put("d", null);
//		ss.put(null, "nullval");
//		ss.put(null, null);
//		ss.put(null, "s");
//		ss.put("e", null);
//
//		System.out.println(ss);

        // it internally uses object hashing
        // unique key and duplicate values

        HashMap<String, Integer> empIds = new HashMap<String, Integer>();

        empIds.put("Venkat", 117);
        empIds.put("Shivam", 2);
        empIds.put("Rishav", 108);
        empIds.put("Sachin", 482923);
        //empIds.put("Krithika", 537304); //
        empIds.put("Krithika", 5304);

        System.out.println(empIds);
        System.out.println("ris " + empIds.get("Shivam"));
        System.out.println(empIds.containsKey("Shivam"));
        System.out.println(empIds.containsValue(117));

        empIds.put("Venkat", 999);
        empIds.put("Shivam", 109);
        empIds.putIfAbsent("Venkat", 207);

        empIds.remove("Sachin");
        System.out.println(empIds);


        //LinkedHashmap

        LinkedHashMap myMap = new LinkedHashMap();

        myMap.put(1,  1);
        myMap.put("a",  "A");
        myMap.put(2,  "9");
        myMap.put(null,  "str");

        System.out.println(myMap);



    }
}













