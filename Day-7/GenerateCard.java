package com.shivamkchoudhary;

import java.util.concurrent.*;

class CardWrap extends Thread{
    public void run() {
        System.out.println("Thread Name :-> " + Thread.currentThread().getName());
    }
}
public class GenerateCard {
    public static void main(String[] args) {

//        ExecutorService executor = Executors.newFixedThreadPool(4);
//
//        for(int i =1; i<=100; i++){
//            executor.execute(new CardWrap());
//        }

        ScheduledExecutorService exe = Executors.newScheduledThreadPool(3);

        exe.scheduleAtFixedRate(new CardWrap(), 5, 3, TimeUnit.SECONDS);

//        exe.scheduleWithFixedDelay(new CardWrap(), 5, 2, TimeUnit.SECONDS);

    }
}
