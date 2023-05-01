package com.shivamkchoudhary;

class Sheet {
    public synchronized void printSheet(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
class Person1 extends Thread{
    Sheet sheet;
    Person1(Sheet sheet) {
        this.sheet = sheet;
    }
    public void run() {
        sheet.printSheet(5);
    }
}
class Person2 extends Thread{
    Sheet sheet;
    Person2(Sheet sheet) {
        this.sheet = sheet;
    }
    public void run() {
        sheet.printSheet(100);
    }
}

public class SynchronizationConcepts {
    public static void main(String[] args) {
        Sheet sheet = new Sheet();
        Person1 p1 = new Person1(sheet);
        Person2 p2 = new Person2(sheet);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t1.start();
        t2.start();
    }
}
