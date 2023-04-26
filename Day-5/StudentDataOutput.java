package com.shivamkchoudhary;

import java.io.*;

public class StudentDataOutput {
    private DataOutputStream dataOutputStream;

    public StudentDataOutput(OutputStream outputStream) {
        dataOutputStream = new DataOutputStream(outputStream);
    }

    public void writeStudent(Student student) throws IOException {
        dataOutputStream.writeUTF(student.getName());
        dataOutputStream.writeBoolean(student.getGender());
        dataOutputStream.writeInt(student.getAge());
        dataOutputStream.writeFloat(student.getGrade());
    }
}
