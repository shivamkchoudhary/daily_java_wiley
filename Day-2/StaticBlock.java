package com.shivamkchoudhary;

public class StaticBlock {
    {
        System.out.println("Instance Block");
    }
    static {
        System.out.println("Static Block");
    }
    public StaticBlock(){
        System.out.println("Constructor Block");
    }
    public static void main(String[] args) {
        new StaticBlock();
        new StaticBlock();
    }
}
