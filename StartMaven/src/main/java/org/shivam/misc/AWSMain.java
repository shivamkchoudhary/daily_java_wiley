package org.shivam.misc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AWSMain {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("file:C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\StartMaven\\src\\main\\java\\org\\shivam\\misc\\config.xml");

        var emp1 = context.getBean("emp");
        System.out.println(emp1);


    }
}
