package com.shivamkchoudhary;

public class FinalBlock {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            int c = a / b;
            System.out.println(c);
            System.out.println("Hola");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
            try {
                System.out.println("This is nested try block");
                System.out.println(a / b);
            } catch (Exception ee) {
                System.out.println("This is nested catch block");
                ee.printStackTrace();
            } finally {
                System.out.println("This is finally block");
            }
            e.printStackTrace();
        }
    }
}
