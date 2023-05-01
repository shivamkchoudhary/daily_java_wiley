package com.shivamkchoudhary;

class BankAccount {
    int amount = 10000;

    public synchronized void withdraw(int amount) {
        System.out.println("Going to withdraw...");

        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
            this.amount -= amount;
            System.out.println("Withdraw completed...");
        }
    }
    public synchronized void deposit(int amount) {
        System.out.println("Going to deposit...");
        this.amount += amount;
        System.out.println("Deposit completed... ");
        notify();
    }
}

public class InterCommunication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread() {
            public void run() {
                account.withdraw(15000);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                account.deposit(10000);
            }
        };
        t1.start();
        t2.start();
    }
}
