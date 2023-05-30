package org.shivam.reftype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("file:C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\StartMaven\\src\\main\\java\\org\\shivam\\reftype\\configure.xml");
        WileyA wa = (WileyA) context.getBean("waref");
        System.out.println(wa.getOb().getCount());
    }
}
