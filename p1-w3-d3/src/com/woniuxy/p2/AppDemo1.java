package com.woniuxy.p2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AppDemo1 {
    public static void main(String[] args) {
        Student s1= new Student(1,"刻晴");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.bin"))) {
            out.writeObject(s1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
