package com.shivamkchoudhary;

@FunctionalInterface
public interface Child extends Parent {
    public void sayHello();

    default void sayHi() {

    }

    //Methods of object class
    String toString();
    int hashCode();
    boolean equals(Object obj);
}