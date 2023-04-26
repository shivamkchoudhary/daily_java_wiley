package com.shivamkchoudhary;

import java.io.*;

public class StudentDataInput {
    private DataInputStream dataInputStream;

    public StudentDataInput(InputStream inputStream) {
        dataInputStream = new DataInputStream(inputStream);
    }

    public Student readStudent() throws IOException {
        String name = dataInputStream.readUTF();
        boolean gender = dataInputStream.readBoolean();
        int age = dataInputStream.readInt();
        float grade = dataInputStream.readFloat();
        return new Student(name, gender, age, grade);
    }
}
