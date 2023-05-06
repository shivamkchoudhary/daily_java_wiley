package com.shivamkchoudhary;

@FunctionalInterface
interface Calc{
    //Abstract method
    int calculate(int val);

//	default int add(int a, int b) {
//		return a + b;
//	}
}

public class FunctionalInterfaceClass {
    public static void main(String[] args) {

        //let's implement abstract method of the Calc interface
        Calc cl = (int val) -> val + 54; // lambda expression

        //Call the method
        System.out.println("Result : " + cl.calculate(54));
    }
}