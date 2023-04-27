package com.shivamkchoudhary;

class TPriority extends Thread{

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(
                    "Thread Name :-> " + Thread.currentThread().getName() +
                            "     " + " Thread Priority :-> " + Thread.currentThread().getPriority()
            );
        }
    }
}
public class ThreadPriority {
    public static void main(String[] args) throws InterruptedException {

//        Thread.currentThread().setPriority(8);
//        System.out.println("Main Thread :-> " + Thread.currentThread().getPriority());
//        TPriority t1 = new TPriority();
//        t1.setPriority(10);
//        TPriority t2 = new TPriority();
        TPriority t1 = new TPriority();
        TPriority t2 = new TPriority();
        TPriority t3 = new TPriority();

        t1.start();
        t1.join(1);
        System.out.println(t1.getState());
        t2.start();
        t2.join();
        System.out.println(t2.getState());
        t3.start();
    }
}
