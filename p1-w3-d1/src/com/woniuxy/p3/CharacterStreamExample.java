package com.woniuxy.p3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CharacterStreamExample {
    public static void main(String[] args) {
        // 写入文本文件
        try (PrintWriter writer = new PrintWriter(new FileWriter("textfile.txt"))) {
            writer.println("Hello, World!");
            writer.println("This is a text file example.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取文本文件
        try (BufferedReader reader = new BufferedReader(new FileReader("textfile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
