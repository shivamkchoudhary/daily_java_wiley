package com.shivamkchoudhary;

public class VarScope {
    int ins = 10;
    int loc = 200;
    static String name = "Shivam";
    int val1 = 10;
    int val2 = 20;
    public void sum(){
        int val1=5;
        int val2=10;
        System.out.println("Sum of 2 values : " + (val1+val2));
        // this can be used bcoz of it's not in static method
        System.out.println("Sum of 2 values : " + (this.val1+this.val2));
    }
    public static void main(String[] args) {
        // this can't be used here
        VarScope v = new VarScope();
        int loc = 20;
        System.out.println("Local variable is : "+ loc);
        System.out.println("Global variable is : "+ v.loc);
        System.out.println("Instance variable is : "+ v.ins);
        System.out.println("Static variable name is : "+ name);
        v.sum();

    }
}
