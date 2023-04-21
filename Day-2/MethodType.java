package com.shivamkchoudhary;

class test {
    public static int add(int a, int b) {
        int val = a + b;
        return val;
    }
}
public class MethodType {

    public void sub(int a, int b){
        int val = a - b;
        System.out.println("Subtraction in instance method using this keyword is : " + val);
    }
    public void add(int a, int b){
        int val = a + b;
        System.out.println("Addition in instance method is : " + val);
        this.sub(val, 100);
    }
    public static void mul(int a, int b){
        int val = a * b;
        System.out.println("Multiplication in static method is : "+val);
    }
    public static int div(int a, int b){
        int val = a / b;
        return val;
    }
    public static void main(String[] args) {
        MethodType m = new MethodType();
        m.add(10,20);
        mul(10,200);
        System.out.println("Division in static method is : "+div(50,5));
        System.out.println("Addition in instance method is : " + test.add(5,2));

    }
}
