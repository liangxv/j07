package com.woniuxy.p2;

import java.io.FileReader;
import java.io.IOException;

public class AppDemo {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("F:\\workspaker\\j07\\p1-w3-d2\\src\\com\\woniuxy\\p1\\AppDemo2.java");
        char[] b =new char[800];
        reader.read(b);
        System.out.println(b);
        reader.close();
    }
}
