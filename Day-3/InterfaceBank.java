package com.shivamkchoudhary;

interface Bank1 {
    void account1();
}
interface Bank2 {
    void account2();
}
interface ATM extends Bank1, Bank2 {
    void InsertCard();
    void SelectOption();
    void EnterPin();
}
interface AA {
    void a();
}

abstract class NewATM implements ATM, AA {
    public void account1() {
        System.out.println("Account 1");
    }
    public void account2() {
        System.out.println("Account 2");
    }
    public void InsertCard() {
        System.out.println("Insert Card");
    }
    public void SelectOption() {
        System.out.println("Select Option");
    }
    public void EnterPin() {
        System.out.println("Enter Pin");
    }
    public void a() {
        System.out.println("a");
    }
}
public class InterfaceBank extends NewATM{
    public void InsertCard() {
        System.out.println("Insert Card");
    }
    public void SelectOption() {
        System.out.println("Select Option");
    }
    public void EnterPin() {
        System.out.println("Enter Pin");
    }
    public void a() {
        System.out.println("a");
    }
}
