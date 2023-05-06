package com.shivamkchoudhary;

import java.util.*;

public class CustomArray extends ArrayList {

    @Override
    public boolean add(Object o) {
        if (this.contains(o)) {
            return false;
        } else {
            return super.add(o);
        }
    }

    public static void main(String[] args) {
        CustomArray list = new CustomArray();

        list.add(1);
        list.add(1);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);

        System.out.println(list);

//        Set<Student> setStudent = new HashSet<>();

        List<Student> setStudent = new ArrayList<>();

        Student s1 = new Student("Shivam", 101);
        Student s2 = new Student("Shiva", 102);
        Student s3 = new Student("Shivani", 102);
        Student s4 = new Student("Shiv", 105);
        Student s5 = new Student("Shi", 103);

        setStudent.add(s1);
        setStudent.add(s2);
        setStudent.add(s3);
        setStudent.add(s4);
        setStudent.add(s5);


        System.out.println(setStudent);
    }

}
