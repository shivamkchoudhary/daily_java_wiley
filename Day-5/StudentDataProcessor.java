package com.shivamkchoudhary;

import java.io.*;

public class StudentDataProcessor {
    public static void main(String[] args) {
        try {
            // Input data
            StudentDataInput input = new StudentDataInput(System.in);
            System.out.print("Enter number of students: ");
            int numStudents = Integer.parseInt(String.valueOf(input.readStudent()));

            Student[] students = new Student[numStudents];
            for (int i = 0; i < numStudents; i++) {
                System.out.println("Enter details for student " + (i + 1) + ":");
                String name = input.readStudent().getName();
                boolean gender = input.readStudent().getGender();
                int age = input.readStudent().getAge();
                float grade = input.readStudent().getGrade();
                students[i] = new Student(name, gender, age, grade);
            }

            // Output data
            StudentDataOutput output = new StudentDataOutput(new FileOutputStream("students.txt"));
            for (Student student : students) {
                output.writeStudent(student);
            }

            System.out.println("Data successfully written to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

