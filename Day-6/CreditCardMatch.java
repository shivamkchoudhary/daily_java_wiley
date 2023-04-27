package com.shivamkchoudhary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardMatch {
    public static void main(String[] args) {

        String cardNumber = "5560-9696-5269-2022";

        Pattern p = Pattern.compile("\\d{4}-\\d{4}-\\d{4}");
        Matcher m = p.matcher(cardNumber);

        String maskedCard = m.replaceAll("xxxx-xxxx-xxxx-");
        System.out.println(maskedCard);
    }
}
