package com.shivamkchoudhary;

public class StringBuilderClass {
    public static void main(String[] args) {
        StringBuilder logMessage = new StringBuilder();
        long timeStamp = System.currentTimeMillis();

        logMessage
                .append("[")
                .append(timeStamp)
                .append("]");
        int userId = 123;

        logMessage
                .append("User ")
                .append(userId)
                .append(": ");
        String message = "Login Successful";
        logMessage.append(message);

        System.out.println(logMessage);

    }

}
