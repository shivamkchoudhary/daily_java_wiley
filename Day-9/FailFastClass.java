package com.shivamkchoudhary;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastClass {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        list.add("Shivam");
        list.add("Shiva");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String e1 = iterator.next();
            System.out.println(iterator.next());
            list.add("Shiv");
        }
        System.out.println(list);
    }
}
