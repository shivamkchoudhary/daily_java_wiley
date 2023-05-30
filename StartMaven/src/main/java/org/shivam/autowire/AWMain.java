package org.shivam.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AWMain {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("file:C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\StartMaven\\src\\main\\java\\org\\shivam\\autowire\\config.xml");
        var emp = context.getBean("emp");
        System.out.println(emp);
    }
}
