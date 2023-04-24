package com.shivamkchoudhary;

abstract class Shape {
    {
        System.out.println("Shape instance block");
    }
    static {
        System.out.println("Shape static block");
    }
    abstract void draw();
    public void display() {
        System.out.println("Displaying Shape");
    }

    public static void main(String[] args) {
        System.out.println("Shape");
    }
    public Shape() {
        System.out.println("Shape class prints Shape");
    }
    static {
        System.out.println("Rectangle  static block");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }
    public Rectangle() {
        System.out.println("Rectangle class prints Rectangle");
    }
}
public class AbstractionExample {
    public static void main(String[] args) {
        Shape shape = new Rectangle();
        Shape shape1 = new Rectangle();
        shape.draw();
        shape.display();
        shape.main(args);

    }
}
