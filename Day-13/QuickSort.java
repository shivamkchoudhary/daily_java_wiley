package com.shivamkchoudhary;

import java.util.*;

public class QuickSort {
    public static List<Integer> quickSort(List<Integer> sequence) {
        int length = sequence.size();
        if (length <= 1) {
            return sequence;
        } else {
            int pivot = sequence.remove(length - 1);

            List<Integer> itemsGreater = new ArrayList<>();
            List<Integer> itemsLower = new ArrayList<>();

            for (int item : sequence) {
                if (item > pivot) {
                    itemsGreater.add(item);
                } else {
                    itemsLower.add(item);
                }
            }

            List<Integer> sortedList = new ArrayList<>();
            sortedList.addAll(quickSort(itemsLower));
            sortedList.add(pivot);
            sortedList.addAll(quickSort(itemsGreater));

            return sortedList;
        }
    }

    public static void main(String[] args) {
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 8, 7, 6, 5, 6, 7, 8, 9, 0));
        List<Integer> sortedList = quickSort(unsortedList);
        System.out.println(sortedList);
    }
}
