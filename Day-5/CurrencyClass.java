package com.shivamkchoudhary;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;
public class CurrencyClass {
    public static void main(String[] args) {
        Currency usd = Currency.getInstance("USD");
        Currency inr = Currency.getInstance("INR");
        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        NumberFormat inrFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        System.out.println("USD: " +  usdFormat.format(100));
        System.out.println("INR: " + inrFormat.format(100));

        // Custom Format
        DecimalFormat df = new DecimalFormat("#,##0.00");
        df.setPositivePrefix("$");
        String reVal = df.format(1000000);
        System.out.println("Custome format : " +reVal);

        Currency cur = Currency.getInstance("USD");
        String symbol = cur.getSymbol();
        String code = cur.getCurrencyCode();

        System.out.println("Symbol : " + symbol);
        System.out.println("Code : " + code);
    }
}
