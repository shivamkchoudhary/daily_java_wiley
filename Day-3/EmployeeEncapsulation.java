package com.shivamkchoudhary;

class Employee{
    private String name;
    private int age;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
class EmployeeImpl{
    public void show(Employee emp){
        System.out.println("Calling show method");
        System.out.println("Name: "+emp.getName());
        System.out.println("Age: "+emp.getAge());
    }
}
public class EmployeeEncapsulation {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Shivam");
        emp.setAge(20);
        //System.out.println("Name: "+emp.getName());
        //System.out.println("Age: "+emp.getAge());
        EmployeeImpl empImpl = new EmployeeImpl();
        empImpl.show(emp);
    }
}
