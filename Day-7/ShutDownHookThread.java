package com.shivamkchoudhary;

class CloseEvent extends Thread{
    public void run(){
        System.out.println("Current Thread :-> " + Thread.currentThread().getName());
    }
}

class CloseEvent1 extends Thread{
    public void run(){
        System.out.println("Current Thread :-> " + Thread.currentThread().getName());
    }
}
public class ShutDownHookThread {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();

        r.addShutdownHook(new CloseEvent());

        for(int i = 1; i<=10; i++){
            CloseEvent1 t1 = new CloseEvent1();
            t1.start();
        }
    }
}
