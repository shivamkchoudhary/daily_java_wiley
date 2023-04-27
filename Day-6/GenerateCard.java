package com.shivamkchoudhary;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CardWrap extends Thread{
    public void run() {
        System.out.println("Thread Name :-> " + Thread.currentThread().getName());
    }
}
public class GenerateCard {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for(int i =1; i<=100; i++){
            executor.execute(new CardWrap());
        }

    }
}
