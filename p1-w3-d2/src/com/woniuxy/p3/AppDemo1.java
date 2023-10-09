package com.woniuxy.p3;

import java.io.FileReader;
import java.io.IOException;

public class AppDemo1 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("E:\\Users\\kotori\\Downloads\\out.txt")) {
            int data=0;
            while ((data= reader.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
