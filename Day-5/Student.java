package com.shivamkchoudhary;

public class Student {
    private String name;
    private boolean gender;
    private int age;
    private float grade;

    public Student(String name, boolean gender, int age, float grade) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }
    public boolean getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    public float getGrade() {
        return grade;
    }
}
