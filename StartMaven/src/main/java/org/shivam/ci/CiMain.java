package org.shivam.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CiMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("file:C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\StartMaven\\src\\main\\java\\org\\shivam\\ci\\ciconfig.xml");
        Person p = (Person) context.getBean("p1");
        System.out.println(p);
    }
}
