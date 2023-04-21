package com.shivamkchoudhary;

class Vehicle1{
    public void steering(){
        System.out.println("Steering wheel....");
    }
}
class Car extends Vehicle1{
    public void airBag(){
        System.out.println("AirBag....");
    }
}
class Truck extends Vehicle1{
    public void HydraulicPump(){
        System.out.println("Hydraulic Pump....");
    }
}
public class HierarchicalInheritancec {
    public static void main(String[] args) {
        Truck t = new Truck();
        t.steering();
        t.HydraulicPump();
        Car c = new Car();
        c.steering();
        c.airBag();
    }
}
