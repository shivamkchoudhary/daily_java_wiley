package com.shivamkchoudhary;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapClasses {
    public static void main(String[] args) {
        Map<String, String> ss = new HashMap<String, String>();

        ss.put("c", "C");
        ss.put("c", "C");
        ss.put("a", "A");
        ss.put("b", "B");
        ss.put("y","");
        ss.put(null, null);
        ss.put(null, "nullvalue");
        ss.put(null, "s");
        ss.put("d", null);

        System.out.println(ss);
        System.out.println(ss.get("c"));
        System.out.println(ss.get("z"));
        System.out.println(ss.containsKey("b"));
    }
}
