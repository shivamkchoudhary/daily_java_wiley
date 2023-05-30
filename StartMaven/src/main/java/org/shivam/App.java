package org.shivam;

import org.springframework.context.*;
import org.springframework.context.support.*;
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("file:C:\\Users\\Shivam\\OneDrive\\Desktop\\Wiley-Java\\StartMaven\\src\\main\\java\\config.xml");
        Student wst1 = (Student)context.getBean("student1");
        Student wst2 = (Student)context.getBean("student2");
        System.out.println(wst1);
        System.out.println(wst2);
    }
}