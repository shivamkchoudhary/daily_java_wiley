package com.shivamkchoudhary;

public class ThrowsClass {
    public static void m1() throws InterruptedException{
        try {
            m2();
        }catch (InterruptedException e){
            System.out.println("Exception caught in m1()");
            e.printStackTrace();
        }
    }
    public static void m2() throws InterruptedException{
        Thread t = new Thread();
        t.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException{
        m1();
    }
}
