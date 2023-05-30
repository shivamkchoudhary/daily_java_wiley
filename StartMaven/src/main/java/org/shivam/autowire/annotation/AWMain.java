package org.shivam.autowire.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AWMain {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("file:C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\StartMaven\\src\\main\\java\\org\\shivam\\autowire\\annotation\\config.xml");
        var p = context.getBean("emp1", Emp.class);
        System.out.println(p.getAddress());
        System.out.println(p.getPhones());
        System.out.println(p.getCourse());

    }
}
