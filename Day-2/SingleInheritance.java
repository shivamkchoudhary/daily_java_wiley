package com.shivamkchoudhary;

class Animal {
    public void eat(){
        System.out.println("Eating...");
    }
    public void sleep(){
        System.out.println("Sleeping...");
    }
}
class Lion extends Animal{
    public void roar(){
        System.out.println("Lion is roaring...");
    }
}
public class SingleInheritance {
    public static void main(String[] args) {
        Lion l = new Lion();
        l.roar();
        l.eat();
        l.sleep();
    }
}
