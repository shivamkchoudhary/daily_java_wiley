package com.shivamkchoudhary;

class SupportClass extends Thread{
    public void run(){
        if(Thread.currentThread().isDaemon()){
            System.out.println("This is Demon");
        }else{
            System.out.println("This is not a Demon thread");
        }
    }
}
public class DemonTypes {
    public static void main(String[] args) {
        SupportClass t1 = new SupportClass();
        SupportClass t2 = new SupportClass();

        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

    }
}
