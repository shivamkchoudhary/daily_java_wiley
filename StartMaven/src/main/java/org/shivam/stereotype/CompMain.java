package org.shivam.stereotype;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompMain {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("file:C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\StartMaven\\src\\main\\java\\org\\shivam\\stereotype\\config.xml");
        Student st = context.getBean("obj", Student.class);
        System.out.println(st);
    }
}