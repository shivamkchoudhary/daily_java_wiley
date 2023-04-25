package com.shivamkchoudhary;

import java.io.FileWriter;
import java.io.IOException;

public class StudentData {
    private String name, gender;
    private int grade, age;
    public StudentData(String name, String gender, int grade, int age) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.age = age;
    }
    public void writeToFile() throws IOException {
        FileWriter writer = new FileWriter("student.txt");
        writer.write("Name: " + name + "\n");
        writer.write("Gender: " + gender + "\n");
        writer.write("Grade: " + grade + "\n");
        writer.write("Age: " + age + "\n");
        writer.close();
    }

    public static void main(String[] args) {
        StudentData student = new StudentData("Shivam", "Male", 10, 22);
        try {
            student.writeToFile();
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}
