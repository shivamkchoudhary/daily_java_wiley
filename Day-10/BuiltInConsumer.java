package com.shivamkchoudhary;

import java.util.function.BiConsumer;

public class BuiltInConsumer {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> el = (Integer age, Integer percent) -> {
            if (age > 18 && percent > 75) {
                System.out.println("You are eligible for the Job");
            } else {
                System.out.println("You are not eligible for the Job");
            }
        };

        el.accept(21, 81);
    }
}