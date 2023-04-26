package com.shivamkchoudhary;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeClass {
    public static void main(String[] args) {
        //Current Date
        LocalDate myDate = LocalDate.now();

        System.out.println(myDate);

        // Current Time
        LocalTime myTime = LocalTime.now();

        System.out.println(myTime);

        // Current Date and Time
        LocalDateTime myDateTime = LocalDateTime.now();

        System.out.println("Before format : " + myDateTime);

        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String modDateTime = myDateTime.format(myDateFormat);
        System.out.println("After format : " + modDateTime);

        String datestr = "26/04/2023";

        LocalDate date = LocalDate.parse(datestr, format);

        System.out.println(date);
    }
}
