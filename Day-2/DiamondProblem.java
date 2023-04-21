package com.shivamkchoudhary;

interface Person {
    public void GetRole();
}
interface Student extends Person{}

class Teacher implements Person{
    @Override
    public void GetRole() {
        System.out.println("Teaching...");
    }
}
class Classroom extends Teacher implements Student{

}
public class DiamondProblem {
}
