package com.shivamkchoudhary;

public class InstanceOrder {
    String name;
    int age;
    {
        name = "Shivam";
        age = 22;
        System.out.println("Instance Block.");
    }
    public InstanceOrder(){
        System.out.println("Name is : "+ name + " Age is : "+age);
        System.out.println("Constructor Block.");
    }
    public InstanceOrder(int a, int b){
        System.out.println("Constructor Parametrized Block : "+ (a+b));
    }
    public static void main(String[] args) {
        InstanceOrder io = new InstanceOrder();
        new InstanceOrder(5,7);

    }
}
