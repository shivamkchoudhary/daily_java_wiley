package com.shivamkchoudhary;

import javax.crypto.spec.PSource;

class Vehicle {
    public void tire(){
        System.out.println("Tires..");
    }
    public void Steering(){
        System.out.println("Steering..");
    }
}
class Features extends Vehicle{
    public void airBag(){
        System.out.println("AirBags...");
    }
}
class SmartCar extends Features{
    public void sensors(){
        System.out.println("Sensors....");
    }
}
public class MultiLevelInheritance {
    public static void main(String[] args) {
        SmartCar sc = new SmartCar();
        sc.sensors();
        sc.airBag();
        sc.tire();
        sc.Steering();
    }
}
