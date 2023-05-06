package com.shivamkchoudhary;

import java.util.HashMap;
import java.util.function.Function;
import java.util.*;

public class BuiltInFunction {
    //to store employees info
    private static HashMap<Integer, String> Employee = new HashMap<>();

    public static void add(String name, int ID) {
        if(!Employee.containsKey(ID)) {
            Employee.put(ID, name);
        }else
            System.out.println("Employee already exist..!");
    }

    public static void main(String[] args) {
        //Function to get the name of the employee name from its ID
        Function<Integer, String> get = (Integer ID) -> {
            if(Employee.containsKey(ID)) return Employee.get(ID);
            else
                return "Invalid ID";
        };

        //Add employees to hashmap
        add("Shivam", 1091);
        add("Jahnavi", 1092);
        add("Anjali", 1093);
        add("Anil", 1094);
        add("Rohit", 1095);

        System.out.println("ID = 1093, Name= "+ get.apply(1093));

    }
}











