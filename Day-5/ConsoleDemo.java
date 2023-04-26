package com.shivamkchoudhary;

import java.io.Console;
public class ConsoleDemo {
    public static void main(String[] args) {
        Console console = System.console();

        if(console == null) {
            System.out.println("No console available");
            System.exit(1);
        }
        String name = console.readLine("Enter your name: ");
        char[] password = console.readPassword("Enter your password: ");

        console.printf("Hello %s, your password is %s", name, new String(password));
    }
}
