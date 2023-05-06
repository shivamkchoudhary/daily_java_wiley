package com.shivamkchoudhary;

//SAM Single Abstract method
// default and static methods can hold
//
@FunctionalInterface
public interface Printable {
    //void print(String Prefix , String suffix); // abstract
    String print(String suffix); // abstract
    //void getName();

    default void sayHi() {

    }

    public static void sayOk() {

    }
}