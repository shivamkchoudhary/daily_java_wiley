package com.shivamkchoudhary;

public class ConstructorTypes {
    public ConstructorTypes(){
        System.out.println("0 args Constructor ");
    }
    public ConstructorTypes(int a, int b) {
        System.out.println("2 args Constructors "+(a+b));
    }
    public ConstructorTypes(float a, int b) {
        this(10,60);
        System.out.println("2 args with float type Constructors "+(a+b));
    }
    public static void main(String[] args) {
        ConstructorTypes ct = new ConstructorTypes();
        ConstructorTypes ctargs = new ConstructorTypes(5.0f,50);

    }
}
