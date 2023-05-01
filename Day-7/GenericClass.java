package com.shivamkchoudhary;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {
    public static void main(String[] args) {
//		Printer<Cat> printer = new Printer(new Cat());
//		printer.print();
//
//		Printer<Dog> printer1 = new Printer(new Dog());
//		printer1.print();
//		ArrayList<Object> cats = new ArrayList<>();
//		cats.add(new Cat());
//		cats.add(new Cat());
//		cats.add(new Dog());

//		shout("Tame me to movie");
//		shout("Bring necklace");
//		shout("Amount", 20000);
//		//shout();

        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        printList(intList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printList(catList);
    }

    private static void printList(List<?> myList) {
        System.out.println(myList);
    }

    private static <T, V> T shout(T shoutOUt, V valtoBring ) {
        System.out.println(shoutOUt + " ...!!!!");
        System.out.println(valtoBring + " ...!!!!");

        return shoutOUt;
    }
}