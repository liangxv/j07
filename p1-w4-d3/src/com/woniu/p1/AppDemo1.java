package com.woniu.p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppDemo1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String filePath = "F:\\workspace\\j07\\p1-w4-d3\\src\\dirtrwords.txt";
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 处理每一行的代码
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.sort(((o1, o2) -> o2.length() - o1.length()));
        System.out.print("输入一句话: ");
        String next = scanner.next();
        String out = "";
        for (String s : list) {
            if (next.contains(s)) {
                String replacement = "";
                for (int i = 0; i < s.length(); i++) {
                    replacement = replacement + "*";
                }
                out = next.replace(s, replacement);
            }
        }
        System.out.println(out);

    }
}
