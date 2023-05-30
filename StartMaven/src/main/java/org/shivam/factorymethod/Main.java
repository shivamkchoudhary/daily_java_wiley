package org.shivam.factorymethod;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("file:C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\StartMaven\\src\\main\\java\\org\\shivam\\factorymethod\\appconfig.xml");
        CBeans clientBean = (CBeans) context.getBean("clientBean");
        clientBean.run();
    }
}

