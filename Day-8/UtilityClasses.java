package com.shivamkchoudhary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UtilityClasses {
    public static void main(String[] args) {
        int arr[] = {5,4,6,8,3,4,2,8,9,2,3,9,1,3,2,6,5,4,3};
        Arrays.sort(arr);

//		for(int i: arr) {
//			System.out.println(i);
//		}

        ArrayList<Integer> al = new ArrayList<>();

        al.add(5);
        al.add(2);
        al.add(4);
        al.add(3);
        al.add(1);

        Collections.sort(al);

        System.out.println(al);
    }
}