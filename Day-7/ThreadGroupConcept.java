package com.shivamkchoudhary;

class Demo implements Runnable{
    public void run() {
        System.out.println("Thread Name :-> " + Thread.currentThread().getName());
    }
}
public class ThreadGroupConcept {
    public static void main(String[] args) {
        ThreadGroup tgParent = new ThreadGroup("Parent Grop");
        ThreadGroup tgChild = new ThreadGroup(tgParent, "Child Group");

        Thread t1 = new Thread(tgParent, new Demo(), "First");
        Thread t2 = new Thread(tgParent, new Demo(), "Second");
        Thread t3 = new Thread(tgParent, new Demo(), "Third");
        Thread t4 = new Thread(tgParent, new Demo(), "Forth");
//        Thread t3 = new Thread(tgChild, new Demo(), "Third");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        System.out.println("Active group of Parents threads :-> " + tgParent.activeCount());
        System.out.println("Active group of Child threads :-> " + tgChild.activeCount());
        tgParent.list();

    }
}
