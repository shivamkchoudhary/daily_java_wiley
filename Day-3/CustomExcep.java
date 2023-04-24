package com.shivamkchoudhary;

public class CustomExcep {
    public static void getAge(int age){
        if(age < 18){
            throw new ArithmeticException("You are not eligible to vote");
        }else{
            System.out.println("You are eligible to vote");
        }
    }
    public static void main(String[] args) throws AgeNotValid {
        getAge(12);
    }
}
