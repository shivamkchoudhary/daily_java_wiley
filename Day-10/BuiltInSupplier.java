package com.shivamkchoudhary;

import java.util.function.Supplier;

public class BuiltInSupplier {
    public static void main(String[] args) {
        Supplier<String> msg = () -> "Wish you happy married life Rishav Raj ...!";
        System.out.println(msg.get());
    }
}